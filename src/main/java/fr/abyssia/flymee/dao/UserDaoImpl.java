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

public class UserDaoImpl implements UserDao {
	PersistenceManagerFactory pmf; 
	
	List<User> userList;
	List<Flight> flightList;

	public UserDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	@SuppressWarnings({"unchecked"})
	public List<User> getUsers() {
		List<User> list = null;
		List<User> detached = new ArrayList<User>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction(); 
		try {
			tx.begin();
			Query q = pm.newQuery(Aerodrome.class);
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
	
	@SuppressWarnings({"unchecked"})
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
			if (!(modif.getFirstName().equals(user.getFirstName()))){
				modif.setFirstName(user.getFirstName());
			}
			if (!(modif.getLastName().equals(user.getLastName()))){
				modif.setLastName(user.getLastName());
			}
			if (!(modif.getEmail().equals(user.getEmail()))){
				modif.setEmail(user.getEmail());
			}
			if (!(modif.getDateOfBirth().equals(user.getDateOfBirth()))){
				modif.setDateOfBirth(user.getDateOfBirth());
			}
			if (!(modif.getPassword().equals(user.getPassword()))){
				modif.setPassword(user.getPassword());
			}
			if (!(modif.getDateOfBirth().equals(user.getDateOfBirth()))){
				modif.setDateOfBirth(user.getDateOfBirth());
			}
			if (!(modif.getProfilePicture().equals(user.getProfilePicture()))){
				modif.setProfilePicture(user.getProfilePicture());
			}
			if (!(modif.getDescription().equals(user.getDescription()))){
				modif.setDescription(user.getDescription());
			}
			if (modif.getWeight() != user.getWeight()){
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
		for (User user : userList) {
			if (user.getId() == userID) {
				return this.flightList;
			}
		}
		return new ArrayList<Flight>();
	}

	public boolean reservedFlight(int userID, int flightID) {
		for (User user : this.userList) {
			if (user.getId() == userID) {
				for (Flight flight : this.flightList) {
					if (flight.getId() == flightID) {
						flight.passengerList.add(user);
						return true;
					}
				}
			}
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
