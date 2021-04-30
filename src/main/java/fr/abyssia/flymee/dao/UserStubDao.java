package com.flymee.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.flymee.models.Aircraft;
import com.flymee.models.Flight;
import com.flymee.models.Pilot;
import com.flymee.models.User;

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
		Flight flight1 = new Flight(1, "NCE", "ORY", LocalDateTime.of(2021, 4, 4, 17, 30),
				LocalDateTime.of(2021, 4, 4, 19, 00), 4, 2, new Pilot(), this.userList, new Aircraft(), 81f, "Nice");
		Flight flight2 = new Flight(2, "ORY", "NCE", LocalDateTime.of(2021, 4, 10, 17, 30, 00),
				LocalDateTime.of(2021, 4, 10, 19, 00), 4, 2, new Pilot(), this.userList, new Aircraft(), 87f,
				"Châtelet");
		this.flightList.add(flight1);
		this.flightList.add(flight2);
	}

	public List<User> getUsers() {
		return userList;
	}

	public User getUser(int userID) {
		for (User user : userList) {
			if (user.id == userID) {
				return user;
			}
		}
		return null;
	}

	public boolean createUser(String userEmail, String userPassword, boolean pilot) {
		User newUser = new User(4, "Oak", "Cacahouète", "oak.cacahouete@gmail.com", LocalDate.of(1999, 10, 17), "1234");
		userList.add(newUser);
		return true;
	}

	public User updateUser(int userID) {
		for (User user : userList) {
			if (user.id == userID) {
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
			if (user.id == userID) {
				userList.remove(user);
				return true;
			}
		}
		return false;
	}

	public List<Flight> getFlights(int userID) {
		for (User user : userList) {
			if (user.id == userID) {
				return this.flightList;
			}
		}
		return new ArrayList<Flight>();
	}

	public boolean reservedFlight(int userID, int flightID) {
		for (User user : this.userList) {
			if (user.id == userID) {
				for (Flight flight : this.flightList) {
					if (flight.id == flightID) {
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
