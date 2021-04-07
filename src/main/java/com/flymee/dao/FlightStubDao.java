package com.flymee.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.flymee.models.Aircraft;
import com.flymee.models.Flight;
import com.flymee.models.Pilot;
import com.flymee.models.User;

public class FlightStubDao implements FlightDao {
	List<Flight> flightList;

	public FlightStubDao() {
		ArrayList<User> userList = new ArrayList<User>();
		User test1 = new User(1, "Jean", "Dupont", "jean.dupont@gmail.com", LocalDate.of(2000, 1, 1), "1234");
		User test2 = new User(2, "Marine", "Dupont", "marine.dupont@gmail.com", LocalDate.of(2000, 1, 2), "1234");
		User test3 = new User(3, "Marc", "Dupont", "marc.dupont@gmail.com", LocalDate.of(2000, 1, 3), "1234");
		userList.add(test1);
		userList.add(test2);
		userList.add(test3);

		this.flightList = new ArrayList<Flight>();
		Flight flight1 = new Flight(1, "NCE", "ORY", LocalDateTime.of(2021, 4, 4, 17, 30),
				LocalDateTime.of(2021, 4, 4, 19, 00, 00), 4, 2, new Pilot(), new ArrayList<User>(), new Aircraft(), 81f,
				"Nice");
		Flight flight2 = new Flight(2, "ORY", "NCE", LocalDateTime.of(2021, 4, 10, 17, 30),
				LocalDateTime.of(2021, 4, 10, 19, 00, 00), 4, 2, new Pilot(), new ArrayList<User>(), new Aircraft(),
				87f, "Ch�telet");
		this.flightList.add(flight1);
		this.flightList.add(flight2);

	}

	public List<Flight> getFlights() {
		return this.flightList;
	}

	public Flight getFlight(int flightID) {
		for (Flight flight : flightList) {
			if (flight.id == flightID) {
				return flight;
			}
		}
		return null;
	}

	public Flight createFlight() {
		Flight newFlight = new Flight(3, "TNS", "ORY", LocalDateTime.of(2021, 6, 4, 17, 30),
				LocalDateTime.of(2021, 6, 4, 19, 00), 4, 2, new Pilot(), new ArrayList<User>(), new Aircraft(), 81f,
				"Tunis");
		flightList.add(newFlight);
		return newFlight;
	}

	public Flight updateFlight(int flightID) {
		for (Flight flight : flightList) {
			if (flight.id == flightID) {
				flightList.remove(flight);
				Flight flightUpdated = new Flight(4, "TNS", "ORY", LocalDateTime.of(2021, 7, 4, 17, 30),
						LocalDateTime.of(2021, 7, 4, 19, 00), 4, 2, new Pilot(), new ArrayList<User>(), new Aircraft(),
						81f, "Tunis");
				flightList.add(flightUpdated);
				return flightUpdated;
			}
		}
		return null;
	}

	public boolean deleteFlight(int flightID) {
		for (Flight flight : flightList) {
			if (flight.id == flightID) {
				flightList.remove(flight);
				return true;
			}
		}
		return false;
	}

	public List<User> getPassengers(int flightID) {
		for (Flight flight : flightList) {
			if (flight.id == flightID) {
				return flight.passengerList;
			}
		}
		return new ArrayList<User>();
	}

	public List<Flight> getSomeFlights(String aerodromeDepature, String timeDeparture) {
		// Si la personne ne rentre que un lieu dans la recherche
		List<Flight> listOfFlight = new ArrayList<Flight>();
		if (timeDeparture == "1900-00-00") {
			for (Flight flight : flightList) {
				if (flight.aerodromeDeparture.equals(aerodromeDepature)) {
					listOfFlight.add(flight);
				}
			}
			return listOfFlight;
		}

		LocalDate dateTime = LocalDate.parse(timeDeparture);

		// Si la personne rentre un lieu et une date compl�te
		for (Flight flight : flightList) {
			LocalDate dateFlight = flight.timeDeparture.toLocalDate();
			if (flight.aerodromeDeparture.equals(aerodromeDepature) && dateTime.equals(dateFlight)) {
				listOfFlight.add(flight);
			}
		}
		return listOfFlight;
	}
}
