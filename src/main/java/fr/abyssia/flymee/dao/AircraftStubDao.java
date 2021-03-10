package fr.abyssia.flymee.dao;

import java.util.ArrayList;
import java.util.List;

import fr.abyssia.flymee.models.Aircraft;
import fr.abyssia.flymee.models.Pilot;

public class AircraftStubDao implements AircraftDao {
	List<Aircraft> aircraftList;

	public AircraftStubDao() {
		this.aircraftList = new ArrayList<Aircraft>();

		Aircraft test1 = new Aircraft(1, new Pilot(), "B74f", 4);
		Aircraft test2 = new Aircraft(2, new Pilot(), "B75f", 3);
		Aircraft test3 = new Aircraft(3, new Pilot(), "B76f", 2);
		aircraftList.add(test1);
		aircraftList.add(test2);
		aircraftList.add(test3);
	}

	public List<Aircraft> getAircrafts() {
		return this.aircraftList;
	}

	public Aircraft getAircraft(int aircraftID) {
		for (Aircraft aircraft : aircraftList) {
			if (aircraft.id == aircraftID) {
				return aircraft;
			}
		}
		return null;
	}

	public Aircraft createAircraft() {
		Aircraft newAircraft = new Aircraft(4, new Pilot(), "B77f", 5);
		aircraftList.add(newAircraft);
		return newAircraft;
	}

	public Aircraft updateAircraft(int aircraftID) {
		for (Aircraft aircraft : aircraftList) {
			if (aircraft.id == aircraftID) {
				aircraftList.remove(aircraft);
				Aircraft aircraftUpdated = new Aircraft(aircraftID, new Pilot(), "B78f", 3);
				aircraftList.add(aircraftUpdated);
				return aircraftUpdated;
			}
		}
		return null;
	}

	public boolean deleteAircraft(int aircraftID) {
		for (Aircraft aircraft : aircraftList) {
			if (aircraft.id == aircraftID) {
				aircraftList.remove(aircraft);
				return true;
			}
		}
		return false;
	}

}
