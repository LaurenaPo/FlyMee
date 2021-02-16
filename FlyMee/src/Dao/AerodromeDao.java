package Dao;

import java.util.List;

import Models.Aerodrome;
import Models.Flight;
import Models.User;

public interface AerodromeDao {
	/**
	 * @return this list of aerodromes
	 */
	List<User> getAerodromes();
	
	/**
	 * @param aerodromeID
	 * @return a specific aerodrome
	 */
	Aerodrome getAerodrome(int aerodromeID);
	
	/**
	 * 
	 * @return a new aerodrome
	 */
	User postAerodrome();
	
	/**
	 * 
	 * @return the update of the aerodrome
	 */
	User putAerodrome();
	
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
