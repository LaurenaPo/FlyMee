package models;

import java.time.LocalTime;
import java.util.List;

public class Flight {
	int id;
	String aerodromeDeparture;
	String aerodromeArrival;
	LocalTime timeDeparture;
	LocalTime timeArrival;
	byte placesNumber;
	byte placesTaken;
	Pilot pilot;
	List<User> passenger;
	Aircraft plane;
	float price;
	String meetingPlace;
	
}
