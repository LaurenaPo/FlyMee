package fr.abyssia.flymee.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import fr.abyssia.flymee.models.Aerodrome;
import fr.abyssia.flymee.models.Aircraft;
import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.Pilot;
import fr.abyssia.flymee.models.User;

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

	public boolean deletePilot(int pilotID) {
		for (Pilot pilot : pilotList) {
			if (pilot.getId() == pilotID) {
				pilotList.remove(pilot);
				return true;
			}
		}
		return false;
	}

	public List<Flight> getFlights(int pilotID) {
		List<Flight> result = new ArrayList<Flight>();
		for (Pilot pilot : pilotList) {
			if (pilot.getId() == pilotID) {
				for (Flight flight : flightList) {
					if (flight.pilot == pilot) {
						result.add(flight);
					}
				}
			}
		}
		return result;
	}

	public List<Aircraft> getAircrafts(int pilotID) {
		List<Aircraft> aircraftList = new ArrayList<Aircraft>();
		for (Pilot pilot : pilotList) {
			if (pilot.getId() == pilotID) {
				Aircraft aircraft1 = new Aircraft(1, pilot, "", 4);
				Aircraft aircraft2 = new Aircraft(2, pilot, "", 5);
				aircraftList.add(aircraft1);
				aircraftList.add(aircraft2);
			}
		}
		return aircraftList;
	}
}
