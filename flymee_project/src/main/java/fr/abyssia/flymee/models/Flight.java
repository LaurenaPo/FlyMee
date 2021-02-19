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
	
}
