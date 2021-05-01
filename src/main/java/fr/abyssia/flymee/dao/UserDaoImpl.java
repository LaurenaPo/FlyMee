package fr.abyssia.flymee.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jdo.PersistenceManagerFactory;

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

	public List<User> getUsers() {
		return userList;
	}

	public User getUser(int userID) {
		for (User user : userList) {
			if (user.getId() == userID) {
				return user;
			}
		}
		return null;
	}

	public User createUser() {
		User newUser = new User(4, "Oak", "Cacahou�te", "oak.cacahouete@gmail.com", LocalDate.of(1999, 10, 17), "1234");
		userList.add(newUser);
		;
		return newUser;
	}

	public User updateUser(int userID) {
		for (User user : userList) {
			if (user.getId() == userID) {
				userList.remove(user);
				User userUpdated = new User(userID, "Kao", "Otoko", "kao.otoko@gmail.com", LocalDate.of(1999, 10, 17),
						"1234");
				userList.add(userUpdated);
				return userUpdated;
			}
		}
		return null;
	}

	public boolean deleteUser(int userID) {
		for (User user : userList) {
			if (user.getId() == userID) {
				userList.remove(user);
				return true;
			}
		}
		return false;
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
