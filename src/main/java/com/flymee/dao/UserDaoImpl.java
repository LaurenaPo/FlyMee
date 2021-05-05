package com.flymee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flymee.models.Flight;
import com.flymee.models.User;

public class UserDaoImpl implements UserDao {

	PersistenceManagerFactory pmf;

	List<User> userList;
	List<Flight> flightList;

	public UserDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@SuppressWarnings({ "unchecked" })
	public List<User> getUsers() {
		List<User> list = null;
		List<User> detached = new ArrayList<User>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(User.class);
			list = (List<User>) q.execute();
			detached = (List<User>) pm.detachCopyAll(list);
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
	public User getUser(int userID) {
		List<User> us = null;
		List<User> detached = new ArrayList<User>();
		User resUs;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(User.class);
			q.declareParameters("private int id");
			q.setFilter("userID == id");
			us = (List<User>) q.execute(userID);
			detached = (List<User>) pm.detachCopyAll(us);
			resUs = detached.get(0);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return resUs;
	}

	public void addUser(User user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(user);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public User updateUser(User user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		User modif;
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			modif = pm.getObjectById(User.class, user.getId());
			if (!(modif.getFirstName().equals(user.getFirstName()))) {
				modif.setFirstName(user.getFirstName());
			}
			if (!(modif.getLastName().equals(user.getLastName()))) {
				modif.setLastName(user.getLastName());
			}
			if (!(modif.getEmail().equals(user.getEmail()))) {
				modif.setEmail(user.getEmail());
			}
			if (!(modif.getPassword().equals(user.getPassword()))) {
				modif.setPassword(user.getPassword());
			}
			if (!(modif.getProfilePicture().equals(user.getProfilePicture()))) {
				modif.setProfilePicture(user.getProfilePicture());
			}
			if (!(modif.getDescription().equals(user.getDescription()))) {
				modif.setDescription(user.getDescription());
			}
			if (modif.getWeight() != user.getWeight()) {
				modif.setWeight(user.getWeight());
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

	public void deleteUser(int userID) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			User us = pm.getObjectById(User.class, userID);
			pm.deletePersistent(us);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public List<Flight> getFlights(int userID) {
		PersistenceManager pm = pmf.getPersistenceManager();
		FlightDaoImpl fdi = (FlightDaoImpl) DaoFactory.getFlightDao();
		ArrayList<Flight> flights = (ArrayList<Flight>) fdi.getFlights();
		ArrayList<Flight> departing = new ArrayList<Flight>();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			for (Flight f : flights) {
				for (User u : f.getPassengerList()) {
					if (u.equals(pm.getObjectById(User.class, userID))) {
						departing.add(f);
					}

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

	public boolean reservedFlight(int userID, int flightID) {
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			User us = pm.getObjectById(User.class, userID);
			Flight fl = pm.getObjectById(Flight.class, flightID);
			for (User u : fl.getPassengerList()) {
				if (u.getId() == userID) {
					// gestion des doublons :
					return false;
				} else if (fl.getPlacesNumber() - fl.getPlacesTaken() < 1) {
					// gestion d'un vol plein
					return false;
				} else {
					fl.getPassengerList().add(us);
					fl.setPlacesTaken(fl.getPlacesTaken() - 1);
					return true;
				}
			}

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return false;
	}

	public boolean login() {
		return true;
	}

	public boolean logout() {
		return true;
	}

}
