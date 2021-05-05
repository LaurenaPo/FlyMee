package com.flymee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flymee.models.Aerodrome;
import com.flymee.models.Flight;

public class AerodromeDaoImpl implements AerodromeDao {
	private PersistenceManagerFactory pmf;

	/*
	 * List<Aerodrome> aerodromeList; List<Flight> flightListDeparture; List<Flight>
	 * flightListArrival;
	 */

	public AerodromeDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Aerodrome> getAerodromes() {
		List<Aerodrome> list = null;
		List<Aerodrome> detached = new ArrayList<Aerodrome>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Aerodrome.class);
			list = (List<Aerodrome>) q.execute();
			detached = (List<Aerodrome>) pm.detachCopyAll(list);
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
	public Aerodrome getAerodrome(int aerodromeID) {
		List<Aerodrome> ad = null;
		List<Aerodrome> detached = new ArrayList<Aerodrome>();
		Aerodrome resAd;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Aerodrome.class);
			q.declareParameters("private int id");
			q.setFilter("aerodromeID == id");
			ad = (List<Aerodrome>) q.execute(aerodromeID);
			detached = (List<Aerodrome>) pm.detachCopyAll(ad);
			resAd = detached.get(0);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return resAd;
	}

	public void addAerodrome(Aerodrome aerodrome) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(aerodrome);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public Aerodrome updateAerodrome(Aerodrome aero) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Aerodrome modif;
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			modif = pm.getObjectById(Aerodrome.class, aero.getId());
			if (!(modif.getCountry().equals(aero.getCountry()))) {
				modif.setCountry(aero.getCountry());
			}
			if (!(modif.getName().equals(aero.getName()))) {
				modif.setName(aero.getName());
			}
			if (!(modif.getCountry().equals(aero.getCountry()))) {
				modif.setCountry(aero.getCountry());
			}
			if (!(modif.getTown().equals(aero.getTown()))) {
				modif.setTown(aero.getTown());
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

	public void deleteAerodrome(int aerodromeID) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Aerodrome ad = pm.getObjectById(Aerodrome.class, aerodromeID);
			pm.deletePersistent(ad);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	public List<Flight> getFlightsDeparture(String aeroName) {
		PersistenceManager pm = pmf.getPersistenceManager();
		FlightDaoImpl fdi = (FlightDaoImpl) DaoFactory.getFlightDao();
		ArrayList<Flight> flights = (ArrayList<Flight>) fdi.getFlights();
		ArrayList<Flight> departing = new ArrayList<Flight>();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			for (Flight f : flights) {
				if (f.getAerodromeDeparture().equals(aeroName)) {
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

	public List<Flight> getFlightsArrival(String aeroName) {
		PersistenceManager pm = pmf.getPersistenceManager();
		FlightDaoImpl fdi = (FlightDaoImpl) DaoFactory.getFlightDao();
		ArrayList<Flight> flights = (ArrayList<Flight>) fdi.getFlights();
		ArrayList<Flight> arriving = new ArrayList<Flight>();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			for (Flight f : flights) {
				if (f.getAerodromeArrival().equals(aeroName)) {
					arriving.add(f);
				}
				tx.commit();
			}

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return arriving;
	}
}