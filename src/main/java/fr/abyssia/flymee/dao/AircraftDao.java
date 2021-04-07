package com.flymee.dao;

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
	void addAircraft(Aircraft aircraft);

	/**
	 * 
	 * @return the update of the aircraft
	 */
	Aircraft updateAircraft(Aircraft air);

	/**
	 * 
	 * @param aircraftID
	 * @return true if the aircraft is successfully deleted, false otherwise
	 */
	void deleteAircraft(int aircraftID);
}
