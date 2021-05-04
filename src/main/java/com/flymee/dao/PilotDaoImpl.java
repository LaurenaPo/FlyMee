package com.flymee.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flymee.models.Aerodrome;
import com.flymee.models.Aircraft;
import com.flymee.models.Flight;
import com.flymee.models.Pilot;
import com.flymee.models.User;

public class PilotDaoImpl implements PilotDao {
	
	PersistenceManagerFactory pmf;

	List<Pilot> pilotList;
	List<Flight> flightList;

	public PilotDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Pilot> getPilots() {
		List<Pilot> list = null;
		List<Pilot> detached = new ArrayList<Pilot>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction(); //ici : retour de tous les aerodromes ? ou par critere de selection ?
		try {
			tx.begin();
			Query q = pm.newQuery(Pilot.class);
			list = (List<Pilot>) q.execute();
			detached = (List<Pilot>) pm.detachCopyAll(list);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}
	
	@SuppressWarnings({ "unchecked" })
	public Pilot getPilot(int pilotID) {

		List<Pilot> pi = null;
		List<Pilot> detached = new ArrayList<Pilot>();
		Pilot resPi;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction(); 
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("private int id");
			q.setFilter("flightID == id");
			pi = (List<Pilot>) q.execute(pilotID);
			detached = (List<Pilot>) pm.detachCopyAll(pi);
			resPi = detached.get(0);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return resPi;
	}

	public void addPilot(Pilot pilot) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(pilot);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public Pilot updatePilot(Pilot pilot) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Pilot modif;
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			modif = pm.getObjectById(Pilot.class, pilot.getId());
			if (!(modif.getExperience().equals(pilot.getExperience()))) {
				modif.setExperience(pilot.getExperience());
			}
			if (!(modif.getQualifications().equals(pilot.getQualifications()))) {
				modif.setQualifications(pilot.getQualifications());
			}
			if (!(modif.getFlightHours() == (pilot.getFlightHours()))) {
				modif.setFlightHours(pilot.getFlightHours());
			}
			if (!(modif.getPhone().equals(pilot.getPhone()))) {
				modif.setPhone(pilot.getPhone());
			}
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return modif;
	}

	public void deletePilot(int pilotID) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Pilot pl = pm.getObjectById(Pilot.class, pilotID);
			pm.deletePersistent(pl);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public List<Flight> getFlights(int pilotID) {
		PersistenceManager pm = pmf.getPersistenceManager();
		FlightDaoImpl fdi = (FlightDaoImpl) DaoFactory.getFlightDao();
		ArrayList<Flight> flights = (ArrayList<Flight>) fdi.getFlights();
		ArrayList<Flight> departing = new ArrayList<Flight>();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			for( Flight f : flights) {
				if (f.getPilot().equals(pm.getObjectById(Pilot.class, pilotID))) {
					departing.add(f);
				}
				tx.commit();
			}
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return departing;
	}

	public List<Aircraft> getAircrafts(int pilotID) {
		PersistenceManager pm = pmf.getPersistenceManager();
		AircraftDaoImpl adi = (AircraftDaoImpl) DaoFactory.getAircraftDao();
		List<Aircraft> all = (ArrayList<Aircraft>) adi.getAircrafts();
		List<Aircraft> list = new ArrayList<Aircraft>();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Pilot p = pm.getObjectById(Pilot.class, pilotID);
			for (Aircraft a : all) {
				if (a.getPilot().equals(p)) {
					list.add(a);
				}
			}
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return list;
		//liste des avions du pilote en question 
	}
}
