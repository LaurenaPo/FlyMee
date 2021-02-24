package fr.abyssia.flymee.dao;

import java.util.List;

import fr.abyssia.flymee.models.Aircraft;
import fr.abyssia.flymee.models.User;

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
	User createAircraft();

	/**
	 * 
	 * @return the update of the aircraft
	 */
	User updateAircraft();

	/**
	 * 
	 * @return true if the aircraft is successfully deleted, false otherwise
	 */
	boolean deleteAircraft();
}
