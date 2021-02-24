package fr.abyssia.flymee.models;

import java.time.LocalTime;
import java.util.List;

public class Flight {
	public int id;
	public String aerodromeDeparture;
	public String aerodromeArrival;
	public LocalTime timeDeparture;
	public LocalTime timeArrival;
	public byte placesNumber;
	public byte placesTaken;
	public Pilot pilot;
	public List<User> passenger;
	public Aircraft aircraft;
	public float price;
	public String meetingPlace;

	public Flight(int id, String aerodromeDeparture, String aerodromeArrival, LocalTime timeDeparture,
			LocalTime timeArrival, byte placesNumber, byte placesTaken, Pilot pilot, List<User> passenger,
			Aircraft aircraft, float price, String meetingPlace) {
		this.id = id;
		this.aerodromeDeparture = aerodromeDeparture;
		this.aerodromeArrival = aerodromeArrival;
		this.timeDeparture = timeDeparture;
		this.timeArrival = timeArrival;
		this.placesNumber = placesNumber;
		this.placesTaken = placesTaken;
		this.pilot = pilot;
		this.passenger = passenger;
		this.aircraft = aircraft;
		this.price = price;
		this.meetingPlace = meetingPlace;
	}

}
