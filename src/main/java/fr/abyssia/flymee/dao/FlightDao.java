package fr.abyssia.flymee.dao;

import java.util.Calendar;
import java.util.List;

import fr.abyssia.flymee.models.Aircraft;
import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.Pilot;
import fr.abyssia.flymee.models.User;

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
	Flight updateFlight(int flightID);

	/**
	 * 
	 * @param flightID
	 * @return true if the flight is successfully deleted, false otherwise
	 */
	boolean deleteFlight(int flightID);

	/**
	 * 
	 * @return the passengers of a flight
	 */
	List<User> getPassengers(int flightID);

}
