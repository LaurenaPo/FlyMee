package dao;

import java.util.List;

import models.Flight;
import models.User;

public interface FlightDao {
	/**
	 * @return this list of flights
	 */
	List<Flight> getFlights();
	
	/**
	 * @param flightID
	 * @return a specific flight
	 */
	Flight getFlight(int flightID);
	
	/**
	 * 
	 * @return a new flight
	 */
	User createFlight();
	
	/**
	 * 
	 * @return the update of the flight
	 */
	User updateFlight();
	
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
