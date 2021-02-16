package Dao;

import java.util.List;

import Models.Flight;
import Models.Pilot;
import Models.Plane;
import Models.User;

public interface PilotDao {
	/**
	 * @return this list of pilots
	 */
	List<Pilot> getPilots();
	
	/**
	 * @param pilotID
	 * @return a specific pilot
	 */
	Pilot getPilots(String pilotID);
	
	/**
	 * 
	 * @return a new pilot
	 */
	User postPilot();
	
	/**
	 * 
	 * @return the update of the pilot
	 */
	User putPilot();
	
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
	List<Flight> getFlightsAdded(String pilotName);
	
	/**
	 * 
	 * @param pilotName
	 * @return the planes of a pilot
	 */
	List<Plane> getPlanes(String pilotName);
}
