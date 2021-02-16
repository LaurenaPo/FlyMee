package dao;

import java.util.List;

import models.Aircraft;
import models.User;

public interface AircraftDao {
	/**
	 * @return this list of aircrafts
	 */
	List<Aircraft> getAircrafts();
	
	/**
	 * @param aircraftID
	 * @return a specific aircraft
	 */
	Aircraft getAircraft(String aircraftID);
	
	/**
	 * 
	 * @return a new aircraft
	 */
	User postAircraft();
	
	/**
	 * 
	 * @return the update of the aircraft
	 */
	User putAircraft();
	
	/**
	 * 
	 * @return true if the aircraft is successfully deleted, false otherwise
	 */
	boolean deleteAircraft();
}
