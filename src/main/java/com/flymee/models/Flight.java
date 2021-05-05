package com.flymee.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Flight {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	public int id;
	public Aerodrome aerodromeDeparture;
	public Aerodrome aerodromeArrival;
	public LocalDateTime timeDeparture;
	public LocalDateTime timeArrival;
	public int placesNumber;
	public int placesTaken;
	public Pilot pilot;
	public List<User> passengerList;
	public Aircraft aircraft;
	public double price;
	public String meetingPlace;

	public Flight(int id, Aerodrome aerodromeDeparture, Aerodrome aerodromeArrival, LocalDateTime timeDeparture,
			LocalDateTime timeArrival, int placesNumber, int placesTaken, Pilot pilot, List<User> passenger,
			Aircraft aircraft, double price, String meetingPlace) {
		this.setId(id);
		this.aerodromeDeparture = aerodromeDeparture;
		this.aerodromeArrival = aerodromeArrival;
		this.timeDeparture = timeDeparture;
		this.timeArrival = timeArrival;
		this.placesNumber = placesNumber;
		this.placesTaken = placesTaken;
		this.pilot = pilot;
		this.passengerList = passenger;
		this.aircraft = aircraft;
		this.price = price;
		this.meetingPlace = meetingPlace;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aerodrome getAerodromeDeparture() {
		return aerodromeDeparture;
	}

	public void setAerodromeDeparture(Aerodrome aerodromeDeparture) {
		this.aerodromeDeparture = aerodromeDeparture;
	}

	public Aerodrome getAerodromeArrival() {
		return aerodromeArrival;
	}

	public void setAerodromeArrival(Aerodrome aerodromeArrival) {
		this.aerodromeArrival = aerodromeArrival;
	}

	public LocalDateTime getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(LocalDateTime timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public LocalDateTime getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(LocalDateTime timeArrival) {
		this.timeArrival = timeArrival;
	}

	public int getPlacesNumber() {
		return placesNumber;
	}

	public void setPlacesNumber(int placesNumber) {
		this.placesNumber = placesNumber;
	}

	public int getPlacesTaken() {
		return placesTaken;
	}

	public void setPlacesTaken(int placesTaken) {
		this.placesTaken = placesTaken;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public List<User> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<User> passengerList) {
		this.passengerList = passengerList;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMeetingPlace() {
		return meetingPlace;
	}

	public void setMeetingPlace(String meetingPlace) {
		this.meetingPlace = meetingPlace;
	}

}
