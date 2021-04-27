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

public class FlightDaoImp implements FlightDao {
	List<Flight> flightList;
	private PersistenceManagerFactory pmf;

	public FlightDaoImp(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	public List<Flight> getFlights() {
		List<Flight> list = null;
		List<Flight> detached = new ArrayList<Flight>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction(); //ici : retour de tous les aerodromes ? ou par critere de selection ?
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

	}

	public Flight updateFlight(int flightID) {
		for (Flight flight : flightList) {
			if (flight.getId() == flightID) {
				flightList.remove(flight);
				Flight flightUpdated = new Flight(4, "TNS", "ORY", new GregorianCalendar(2021, 7, 4, 17, 30),
						new GregorianCalendar(2021, 7, 4, 19, 00), 4, 2, new Pilot(), new ArrayList<User>(),
						new Aircraft(), 81f, "Tunis");
				flightList.add(flightUpdated);
				return flightUpdated;
			}
		}
		return null;
	}

	public boolean deleteFlight(int flightID) {
		for (Flight flight : flightList) {
			if (flight.getId() == flightID) {
				flightList.remove(flight);
				return true;
			}
		}
		return false;
	}

	public List<User> getPassengers(int flightID) {
		for (Flight flight : flightList) {
			if (flight.getId() == flightID) {
				return flight.passengerList;
			}
		}
		return new ArrayList<User>();
	}
}
