package com.flymee.dao;

import java.util.List;

import com.flymee.models.Flight;
import com.flymee.models.User;

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
	void addFlight(Flight flight);

	/**
	 * 
	 * @return the update of the flight
	 */
	Flight updateFlight(Flight flight);

	/**
	 * 
	 * @param flightID
	 * @return true if the flight is successfully deleted, false otherwise
	 */
	void deleteFlight(int flightID);

	/**
	 * 
	 * @return the passengers of a flight
	 */
	List<User> getPassengers(int flightID);

}
