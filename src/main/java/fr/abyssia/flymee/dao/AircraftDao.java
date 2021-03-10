package fr.abyssia.flymee.dao;

import java.util.List;

import fr.abyssia.flymee.models.Aircraft;

public interface AircraftDao {
	/**
	 * @return this list of aircrafts
	 */
	List<Aircraft> getAircrafts();

	/**
	 * @param aircraftID
	 * @return a specific aircraft
	 */
	Aircraft getAircraft(int aircraftID);

	/**
	 * 
	 * @return a new aircraft
	 */
	Aircraft createAircraft();

	/**
	 * 
	 * @return the update of the aircraft
	 */
	Aircraft updateAircraft(int aircraftID);

	/**
	 * 
	 * @param aircraftID
	 * @return true if the aircraft is successfully deleted, false otherwise
	 */
	boolean deleteAircraft(int aircraftID);
}
