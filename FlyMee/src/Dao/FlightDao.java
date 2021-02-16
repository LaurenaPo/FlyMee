package Dao;

import java.util.List;

import Models.Flight;
import Models.User;

public interface FlightDao {
	/**
	 * @return this list of flights
	 */
	List<User> getFlights();
	
	/**
	 * @param flightID
	 * @return a specific flight
	 */
	Flight getFlight(int flightID);
	
	/**
	 * 
	 * @return a new flight
	 */
	User postFlight();
	
	/**
	 * 
	 * @return the update of the flight
	 */
	User putFlight();
	
	/**
	 * 
	 * @return true if the flight is successfully deleted, false otherwise
	 */
	boolean deleteFlight();
	
	/**
	 * 
	 * @return the passengers of a flight
	 */
	List<User> getPassengers();
}
