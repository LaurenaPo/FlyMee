package com.flymee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flymee.models.Flight;
import com.flymee.models.User;

public class FlightDaoImpl implements FlightDao {
	List<Flight> flightList;
	private PersistenceManagerFactory pmf;

	public FlightDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Flight> getFlights() {
		List<Flight> list = null;
		List<Flight> detached = new ArrayList<Flight>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction(); // ici : retour de tous les aerodromes ? ou par critere de selection ?
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			list = (List<Flight>) q.execute();
			detached = (List<Flight>) pm.detachCopyAll(list);
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
	public Flight getFlight(int flightID) {
		List<Flight> fl = null;
		List<Flight> detached = new ArrayList<Flight>();
		Flight resFl;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("private int id");
			q.setFilter("flightID == id");
			fl = (List<Flight>) q.execute(flightID);
			detached = (List<Flight>) pm.detachCopyAll(fl);
			resFl = detached.get(0);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return resFl;
	}

	public void addFlight(Flight flight) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(flight);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public Flight updateFlight(Flight flight) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Flight modif;
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			modif = pm.getObjectById(Flight.class, flight.getId());
			if (!(modif.getAerodromeDeparture().equals(flight.getAerodromeDeparture()))) {
				modif.setAerodromeDeparture(flight.getAerodromeDeparture());
			}
			if (!(modif.getAerodromeArrival().equals(flight.getAerodromeArrival()))) {
				modif.setAerodromeArrival(flight.getAerodromeArrival());
			}
			if (!(modif.getTimeDeparture().equals(flight.getTimeDeparture()))) {
				modif.setTimeDeparture(flight.getTimeDeparture());
			}
			if (!(modif.getTimeArrival().equals(flight.getTimeArrival()))) {
				modif.setTimeArrival(flight.getTimeArrival());
			}
			if (modif.getPlacesNumber() != flight.getPlacesNumber()) {
				modif.setPlacesNumber(flight.getPlacesNumber());
			}
			if (modif.getPlacesTaken() != flight.getPlacesTaken()) {
				modif.setPlacesTaken(flight.getPlacesTaken());
			}
			if (modif.getPassengerList() != flight.getPassengerList()) {
				modif.setPassengerList(flight.getPassengerList());
			}
			if (!(modif.getAircraft().equals(flight.getAircraft()))) {
				modif.setAircraft(flight.getAircraft());
			}
			if (modif.getPrice() != flight.getPrice()) {
				modif.setPrice(flight.getPrice());
			}
			if (!(modif.getMeetingPlace().equals(flight.getMeetingPlace()))) {
				modif.setMeetingPlace(flight.getMeetingPlace());
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

	public void deleteFlight(int flightID) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Flight fl = pm.getObjectById(Flight.class, flightID);
			pm.deletePersistent(fl);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public List<User> getPassengers(int flightID) {
		PersistenceManager pm = pmf.getPersistenceManager();
		List<User> passengers = new ArrayList<User>();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Flight fl = pm.getObjectById(Flight.class, flightID);
			passengers = fl.getPassengerList();

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return passengers;

	}

	@Override
	public List<Flight> getSomeFlights(String aerodromeDepature, String timeDeparture) {
		// TODO Auto-generated method stub
		return null;
	}
}
