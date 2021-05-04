package com.flymee.dao;

import java.util.ArrayList;
import java.util.List;

import com.flymee.models.Aircraft;
import com.flymee.models.Pilot;

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
			if (aircraft.getId() == aircraftID) {
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
			if (aircraft.getId() == aircraftID) {
				aircraftList.remove(aircraft);
				Aircraft aircraftUpdated = new Aircraft(aircraftID, new Pilot(), "B78f", 3);
				aircraftList.add(aircraftUpdated);
				return aircraftUpdated;
			}
		}
		return null;
	}

	public void deleteAircraft(int aircraftID) {
		for (Aircraft aircraft : aircraftList) {
			if (aircraft.getId() == aircraftID) {
				aircraftList.remove(aircraft);
				return;
			}
		}
	}

	@Override
	public void addAircraft(Aircraft aircraft) {
		// TODO Auto-generated method stub

	}

	@Override
	public Aircraft updateAircraft(Aircraft air) {
		// TODO Auto-generated method stub
		return null;
	}

}
