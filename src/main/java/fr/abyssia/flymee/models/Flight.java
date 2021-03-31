package fr.abyssia.flymee.models;

import java.util.Calendar;
import java.util.List;

public class Flight {
	protected int id;
	protected String aerodromeDeparture;
	protected String aerodromeArrival;
	protected Calendar timeDeparture;
	public Calendar timeArrival;
	public int placesNumber;
	public int placesTaken;
	public Pilot pilot;
	public List<User> passengerList;
	public Aircraft aircraft;
	public float price;
	public String meetingPlace;

	public Flight(int id, String aerodromeDeparture, String aerodromeArrival, Calendar timeDeparture,
			Calendar timeArrival, int placesNumber, int placesTaken, Pilot pilot, List<User> passenger,
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
