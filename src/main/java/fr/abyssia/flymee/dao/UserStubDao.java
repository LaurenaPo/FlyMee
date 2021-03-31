package fr.abyssia.flymee.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import fr.abyssia.flymee.models.Aircraft;
import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.Pilot;
import fr.abyssia.flymee.models.User;

public class UserStubDao implements UserDao {

	List<User> userList;
	List<Flight> flightList;

	public UserStubDao() {
		this.userList = new ArrayList<User>();
		User test1 = new User(1, "Jean", "Dupont", "jean.dupont@gmail.com", LocalDate.of(2000, 1, 1), "1234");
		User test2 = new User(2, "Marine", "Dupont", "marine.dupont@gmail.com", LocalDate.of(2000, 1, 2), "1234");
		User test3 = new User(3, "Marc", "Dupont", "marc.dupont@gmail.com", LocalDate.of(2000, 1, 3), "1234");
		this.userList.add(test1);
		this.userList.add(test2);
		this.userList.add(test3);

		this.flightList = new ArrayList<Flight>();
		Flight flight1 = new Flight(1, "NCE", "ORY", new GregorianCalendar(2021, 4, 4, 17, 30),
				new GregorianCalendar(2021, 4, 4, 19, 00), 4, 2, new Pilot(), this.userList, new Aircraft(), 81f,
				"Nice");
		Flight flight2 = new Flight(2, "ORY", "NCE", new GregorianCalendar(2021, 4, 10, 17, 30),
				new GregorianCalendar(2021, 4, 10, 19, 00), 4, 2, new Pilot(), this.userList, new Aircraft(), 87f,
				"Ch�telet");
		this.flightList.add(flight1);
		this.flightList.add(flight2);
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