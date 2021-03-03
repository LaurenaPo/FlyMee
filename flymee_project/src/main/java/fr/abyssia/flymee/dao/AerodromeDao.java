package fr.abyssia.flymee.dao;

import java.util.List;

import fr.abyssia.flymee.models.Aerodrome;
import fr.abyssia.flymee.models.Flight;

public interface AerodromeDao {
	/**
	 * @return this list of aerodromes
	 */
	List<Aerodrome> getAerodromes();

	/**
	 * @param aerodromeID
	 * @return a specific aerodrome
	 */
	Aerodrome getAerodrome(int aerodromeID);

	/**
	 * 
	 * @return a new aerodrome
	 */
	Aerodrome createAerodrome();

	/**
	 * 
	 * @return the update of the aerodrome
	 */
	Aerodrome updateAerodrome(int aerodromeID);

	/**
	 * 
	 * @return true if the aerodrome is successfully deleted, false otherwise
	 */
	boolean deleteAerodrome();

	/**
	 * 
	 * @return all the flights of a specific departure
	 */
	List<Flight> getFlightsDeparture();

	/**
	 * 
	 * @return all the flights of a specific arrival
	 */
	List<Flight> getFlightsArrival();
}
