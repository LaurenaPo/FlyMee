package fr.abyssia.flymee.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import fr.abyssia.flymee.models.Aerodrome;
import fr.abyssia.flymee.models.Aircraft;
import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.Pilot;
import fr.abyssia.flymee.models.User;

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
		Flight flight1 = new Flight(1, "NCE", "ORY", new GregorianCalendar(2021, 4, 4, 17, 30),
				new GregorianCalendar(2021, 4, 4, 19, 00), 4, 2, new Pilot(), new ArrayList<User>(), new Aircraft(),
				81f, "Nice");
		Flight flight2 = new Flight(2, "NCE", "TNS", new GregorianCalendar(2021, 4, 10, 17, 30),
				new GregorianCalendar(2021, 4, 10, 19, 00), 4, 2, new Pilot(), new ArrayList<User>(), new Aircraft(),
				87f, "Nice");
		this.flightListDeparture.add(flight1);
		this.flightListDeparture.add(flight2);

		this.flightListArrival = new ArrayList<Flight>();
		Flight flight3 = new Flight(1, "ORY", "NCE", new GregorianCalendar(2021, 5, 4, 18, 30),
				new GregorianCalendar(2021, 5, 4, 20, 00), 4, 2, new Pilot(), new ArrayList<User>(), new Aircraft(),
				83f, "Ch�telet");
		Flight flight4 = new Flight(2, "TNS", "NCE", new GregorianCalendar(2021, 7, 10, 16, 30),
				new GregorianCalendar(2021, 7, 10, 19, 00), 4, 2, new Pilot(), new ArrayList<User>(), new Aircraft(),
				84f, "Tunis");
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

	public boolean deleteAerodrome(int aerodromeID) {
		for (Aerodrome aerodrome : aerodromeList) {
			if (aerodrome.getId() == aerodromeID) {
				aerodromeList.remove(aerodrome);
				return true;
			}
		}
		return false;
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

}