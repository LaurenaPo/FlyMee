package com.flymee.models;

import java.time.LocalDateTime;
import java.util.List;

public class Flight {
	public int id;
	public String aerodromeDeparture;
	public String aerodromeArrival;
	public LocalDateTime timeDeparture;
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
		this.id = id;
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

}
