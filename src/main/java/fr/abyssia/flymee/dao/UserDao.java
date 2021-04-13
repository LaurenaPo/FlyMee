package com.flymee.dao;

import java.util.List;

import fr.abyssia.flymee.models.Flight;

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
	 * @param userEmail
	 * @return true is this email exist
	 */
	boolean getEmail(String userEmail);

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
	boolean login();

	/**
	 * 
	 * @return true if the user is well unlogged, false otherwise
	 */
	boolean logout();

}
