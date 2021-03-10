package fr.abyssia.flymee.dao;

import java.util.List;

import fr.abyssia.flymee.models.Aircraft;
import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.Pilot;

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
	Pilot createPilot();

	/**
	 * 
	 * @return the update of the pilot
	 */
	Pilot updatePilot();

	/**
	 * 
	 * @return true if the pilot is successfully deleted, false otherwise
	 */
	boolean deletePilot();

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
