package com.flymee.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.flymee.models.Aerodrome;
import com.flymee.models.Aircraft;
import com.flymee.models.Flight;
import com.flymee.models.Pilot;
import com.flymee.models.User;

public class AerodromeStubDao implements AerodromeDao {
	List<Aerodrome> aerodromeList;
	List<Flight> flightListDeparture;
	List<Flight> flightListArrival;

	public AerodromeStubDao() {
		this.aerodromeList = new ArrayList<Aerodrome>();
		Aerodrome aerodrome1 = new Aerodrome(1, "France", "Paris", "ORY");
		Aerodrome aerodrome2 = new Aerodrome(2, "France", "Nice", "NCE");
		Aerodrome aerodrome3 = new Aerodrome(3, "Tunisie", "Tunis", "TNS");
		this.aerodromeList.add(aerodrome1);
		this.aerodromeList.add(aerodrome2);
		this.aerodromeList.add(aerodrome3);

		this.flightListDeparture = new ArrayList<Flight>();
		this.flightListArrival = new ArrayList<Flight>();
		Flight flight1 = new Flight(1, "NCE", "ORY", LocalDateTime.of(2021, 4, 4, 17, 30),
				LocalDateTime.of(2021, 4, 4, 19, 00, 00), 4, 2, new Pilot(), new ArrayList<User>(), new Aircraft(), 81f,
				"Nice");
		this.flightListDeparture.add(flight1);

		this.flightListArrival = new ArrayList<Flight>();
		Flight flight3 = new Flight(1, "ORY", "NCE", LocalDateTime.of(2021, 5, 4, 18, 30),
				LocalDateTime.of(2021, 5, 4, 20, 00), 4, 2, new Pilot(), new ArrayList<User>(), new Aircraft(), 83f,
				"Châtelet");
		Flight flight4 = new Flight(2, "TNS", "NCE", LocalDateTime.of(2021, 7, 10, 16, 30),
				LocalDateTime.of(2021, 7, 10, 19, 00), 4, 2, new Pilot(), new ArrayList<User>(), new Aircraft(), 84f,
				"Tunis");
		this.flightListArrival.add(flight3);
		this.flightListArrival.add(flight4);
	}

	public List<Aerodrome> getAerodromes() {
		return aerodromeList;
	}

	public Aerodrome getAerodrome(int aerodromeID) {
		for (Aerodrome aerodrome : aerodromeList) {
			if (aerodrome.getId() == aerodromeID) {
				return aerodrome;
			}
		}
		return null;
	}

	public Aerodrome createAerodrome() {
		Aerodrome newAerodrome = new Aerodrome(4, "Egypte", "Alexandrie", "ALX");
		aerodromeList.add(newAerodrome);
		;
		return newAerodrome;
	}

	public Aerodrome updateAerodrome(int aerodromeID) {
		for (Aerodrome aerodrome : aerodromeList) {
			if (aerodrome.getId() == aerodromeID) {
				aerodromeList.remove(aerodrome);
				Aerodrome aerodromeUpdated = new Aerodrome(aerodromeID, "France", "Bordeaux", "Jupiter");
				aerodromeList.add(aerodromeUpdated);
				return aerodromeUpdated;
			}
		}
		return null;
	}

	public void deleteAerodrome(int aerodromeID) {
		for (Aerodrome aerodrome : aerodromeList) {
			if (aerodrome.getId() == aerodromeID) {
				aerodromeList.remove(aerodrome);
				return;
			}
		}
	}

	public List<Flight> getFlightsDeparture(int aerodromeID) {
		for (Aerodrome aerodrome : aerodromeList) {
			if (aerodrome.getId() == aerodromeID) {
				return this.flightListDeparture;
			}
		}
		return new ArrayList<Flight>();
	}

	public List<Flight> getFlightsArrival(int aerodromeID) {
		for (Aerodrome aerodrome : aerodromeList) {
			if (aerodrome.getId() == aerodromeID) {
				return this.flightListArrival;
			}
		}
		return new ArrayList<Flight>();
	}

	@Override
	public void addAerodrome(Aerodrome aero) {
		// TODO Auto-generated method stub

	}

	@Override
	public Aerodrome updateAerodrome(Aerodrome aero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> getFlightsDeparture(String name) {
		List<Flight> flightList = new ArrayList<Flight>();
		for (Flight flight : flightListDeparture) {
			if (flight.getAerodromeDeparture().equals(name)) {
				flightList.add(flight);
			}
		}
		return flightList;
	}

	@Override
	public List<Flight> getFlightsArrival(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
