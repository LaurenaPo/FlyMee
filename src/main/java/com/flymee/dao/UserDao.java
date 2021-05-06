package com.flymee.dao;

import java.util.List;

import com.flymee.models.Flight;
import com.flymee.models.User;

public interface UserDao {
	/**
	 * @return this list of users
	 */
	List<User> getUsers();

	/**
	 * @param userID
	 * @return a specific user
	 */
	User getUser(int userID);

	/**
	 * 
	 * @return a new user
	 */
	void addUser(User user);

	/**
	 * 
	 * @param userID
	 * @return the update of the user
	 */
	User updateUser(User user);

	/**
	 * 
	 * @param userID
	 * @return true if the user is successfully deleted, false otherwise
	 */
	void deleteUser(int userID);

	/**
	 * 
	 * @param userID
	 * @return the flight list of a user
	 */
	List<Flight> getFlights(int userID);

	/**
	 * 
	 * @param userID
	 * @param flightID
	 * @return true if the flight is well reserved, false otherwise
	 */
	boolean reservedFlight(int userID, int flightID);

	/**
	 * 
	 * @return true if the user is well logged, false otherwise
	 */
	User login(String email, String password);

	/**
	 * 
	 * @return true if the user is well unlogged, false otherwise
	 */
	boolean logout();

}
