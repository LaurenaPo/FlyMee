import java.time.LocalTime;
import java.util.List;

public class Flight {
	int id;
	String aerodromeDeparture;
	String aerodromeArrival;
	LocalTime timeDeparture;
	LocalTime timeArrival;
	byte placesNumber;
	Pilot pilot;
	List<Passenger> passenger;
	Plane plane;
	float price;
	String meetingPlace;
	
	
}
