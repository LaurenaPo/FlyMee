package com.flymee.dao;

import java.util.List;

import com.flymee.models.Aircraft;
import com.flymee.models.Flight;
import com.flymee.models.Pilot;

public interface PilotDao {
	/**
	 * @return this list of pilots
	 */
	List<Pilot> getPilots();

	/**
	 * @param pilotID
	 * @return a specific pilot
	 */
	Pilot getPilot(int pilotID);

	/**
	 * 
	 * @return a new pilot
	 */
	void addPilot(Pilot pilot);

	/**
	 * 
	 * @param pilotID
	 * @return the update of the pilot
	 */
	Pilot updatePilot(Pilot pilot);

	/**
	 * 
	 * @param pilotID
	 * @return true if the pilot is successfully deleted, false otherwise
	 */
	void deletePilot(int pilotID);

	/**
	 * 
	 * @param pilotID
	 * @return the flights added by a pilot
	 */
	List<Flight> getFlights(int pilotID);

	/**
	 * 
	 * @param pilotID
	 * @return the aircrafts of a pilot
	 */
	List<Aircraft> getAircrafts(int pilotID);
}
