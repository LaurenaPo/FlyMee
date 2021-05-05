package com.flymee.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;

import com.fasterxml.jackson.annotation.JsonFormat;

@PersistenceCapable
public class Flight {
	public int id;
	public String aerodromeDeparture;
	public String aerodromeArrival;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	public LocalDateTime timeDeparture;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	public LocalDateTime timeArrival;
	public int placesNumber;
	public int placesTaken;
	public Pilot pilot;
	public List<User> passengerList;
	public Aircraft aircraft;
	public float price;
	public String meetingPlace;

	public Flight(int id, String aerodromeDeparture, String aerodromeArrival, LocalDateTime timeDeparture,
			LocalDateTime timeArrival, int placesNumber, int placesTaken, Pilot pilot, List<User> passenger,
			Aircraft aircraft, float price, String meetingPlace) {
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

	public String getAerodromeDeparture() {
		return aerodromeDeparture;
	}

	public void setAerodromeDeparture(String aerodromeDeparture) {
		this.aerodromeDeparture = aerodromeDeparture;
	}

	public String getAerodromeArrival() {
		return aerodromeArrival;
	}

	public void setAerodromeArrival(String aerodromeArrival) {
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getMeetingPlace() {
		return meetingPlace;
	}

	public void setMeetingPlace(String meetingPlace) {
		this.meetingPlace = meetingPlace;
	}

}
