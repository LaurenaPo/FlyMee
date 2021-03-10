package fr.abyssia.flymee.dao;

import java.util.List;

import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.User;

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
	User createUser();

	/**
	 * 
	 * @param userID
	 * @return the update of the user
	 */
	User updateUser(int userID);

	/**
	 * 
	 * @param userID
	 * @return true if the user is successfully deleted, false otherwise
	 */
	boolean deleteUser(int userID);

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
