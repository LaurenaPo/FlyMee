package dao;

import java.util.List;

import models.Flight;
import models.User;

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
	 * @return the update of the user
	 */
	User updateUser();
	
	/**
	 * 
	 * @return true if the user is successfully deleted, false otherwise
	 */
	boolean deleteUser();
	
	/**
	 * 
	 * @param username
	 * @return the flight list of a user
	 */
	List<Flight> getFlights(String username);
	
	/**
	 * 
	 * @param username
	 * @return true if the flight is well reserved, false otherwise
	 */
	boolean reservedFlight(String username);

}
