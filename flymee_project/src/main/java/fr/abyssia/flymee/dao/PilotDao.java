package fr.abyssia.flymee.dao;

import java.util.List;

import fr.abyssia.flymee.models.Aircraft;
import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.Pilot;
import fr.abyssia.flymee.models.User;

public interface PilotDao {
	/**
	 * @return this list of pilots
	 */
	List<Pilot> getPilots();

	/**
	 * @param pilotID
	 * @return a specific pilot
	 */
	Pilot getPilot(String pilotID);

	/**
	 * 
	 * @return a new pilot
	 */
	User createPilot();

	/**
	 * 
	 * @return the update of the pilot
	 */
	User updatePilot();

	/**
	 * 
	 * @return true if the pilot is successfully deleted, false otherwise
	 */
	boolean deletePilot();

	/**
	 * 
	 * @param username
	 * @return the flight added by a pilot
	 */
	List<Flight> getFlights(String pilotName);

	/**
	 * 
	 * @param pilotName
	 * @return the planes of a pilot
	 */
	List<Aircraft> getPlanes(String pilotName);
}
