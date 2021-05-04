package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.flymee.dao.DaoFactory;
import com.flymee.dao.AerodromeDao;
import com.flymee.dao.AerodromeDaoImpl;
import com.flymee.dao.AircraftDao;
import com.flymee.dao.AircraftDaoImpl;
import com.flymee.dao.FlightDao;
import com.flymee.dao.FlightDaoImpl;
import com.flymee.dao.PilotDao;
import com.flymee.dao.PilotDaoImpl;
import com.flymee.dao.UserDao;
import com.flymee.dao.UserDaoImpl;import com.flymee.dao.DaoFactory;
import com.flymee.models.Aerodrome;
import com.flymee.models.Aircraft;
import com.flymee.models.Flight;
import com.flymee.models.Pilot;
import com.flymee.models.User;



public class FlightImplTest {
	
	@SuppressWarnings({ "unused", "deprecation" })
	@Test
	public void test() {
		FlightDao fdi = DaoFactory.getFlightDao();
		AerodromeDao adi = DaoFactory.getAerodromeDao();
		AircraftDao aidi = DaoFactory.getAircraftDao();
		UserDao udi = DaoFactory.getUserDao();
		PilotDao pdi = DaoFactory.getPilotDao();
		
		Pilot p1 = new Pilot(1, "Jean", "Michel","jm@mail.fr", LocalDate.of(1950, 10, 10),"mdp", "photo","pilote chevronne",85, "20 ans", "licence tourisme", 450, "0605040302");
		Pilot p2 = new Pilot(2, "Jean", "Francois","jf@mail.fr", LocalDate.of(1950, 2, 10),"mdp", "photo","pilote philanthrope",85, "2 ans", "licence 4", 21, "0605050302");
		Pilot p3 = new Pilot(1, "Jean", "Mouloud","jmou@mail.fr", LocalDate.of(1950, 1, 10),"mdp", "photo","pirate de l'air",72, "13 ans", "licence tourisme", 202, "0605040303");
		User u1 = new User(1, "Jean", "Truc","jt@mail.fr", LocalDate.of(1990, 10, 10),"mdp");
		User u2 = new User(1, "Machin", "Truc","mt@mail.fr", LocalDate.of(1991, 10, 10),"mdp");
		User u3 = new User(1, "Fred", "Truc","ft@mail.fr", LocalDate.of(1980, 10, 10),"mdp");
		User u4 = new User(1, "Pierre", "Pierre","pp@mail.fr", LocalDate.of(1900, 10, 10),"mdp");
		Aircraft aircraft1 =new Aircraft(1,,10,(long) 1520);
		Aircraft aircraft2 =new Aircraft("PHOENIX40","Boeing",10,(long) 4213);
		Aircraft aircraft3 =new Aircraft("PHOENIX44","Boeing",10,(long) 1597);
		Long aircraftId1=aircraft1.getTailNumber();
		Long aircraftId2=aircraft2.getTailNumber();

		Pilot pilot1=new Pilot("Rayan","Gosling","rayan@mail.fr","07XXX",new Date(1980,03,16),200);
		Pilot pilot2=new Pilot("Harry","Potter","potter@mail.fr","07XXX",new Date(1988,12,16),200);
		Pilot pilot3=new Pilot("Scarlett","Johanson","sjohan@mail.fr","07XXX",new Date(1983,12,16),200);
		Pilot pilot4=new Pilot("Tristan","Ottaviano","ottaviano@mail.fr","07XXX",new Date(1999,11,18),50);
		
		Passenger passenger1=new Passenger("Hiba","SOUBER","hiba@mail.fr","06XXX",new Date(1999,06,12));
		Passenger passenger2=new Passenger("Othmane","SOUBER","othmane@mail.fr","07XXX",new Date(1996,02,8));
		Passenger passenger3=new Passenger("Saadia","SOUBER","saadia@mail.fr","08XXX",new Date(1971,06,10));
		Passenger passenger4=new Passenger("Quentin","TARANTINO","quentin@mail.fr","03XXX",new Date(1963,03,27));
		Passenger passenger5=new Passenger("Stanley","KUBRICK","stan@mail.fr","09XXX",new Date(1928,07,26));
		Passenger passenger6=new Passenger("Naruto","Uzumaki","naruto@mail.fr","02XXX",new Date(1999,07,23));	
		
		aircraftDao.addAircraft(aircraft1);
		aircraftDao.addAircraft(aircraft2);
		aircraftDao.addAircraft(aircraft3);
		Assert.assertEquals(3, aircraftDao.getFleet().size());
		aircraftDao.deleteAircraft((long) 2);
		Assert.assertEquals(2, aircraftDao.getFleet().size());	
		
		pilotDao.addPilot(pilot1);
		pilotDao.addPilot(pilot2);
		pilotDao.addPilot(pilot3);
		pilotDao.addPilot(pilot4);
		Assert.assertEquals(4, pilotDao.getPilots().size());
		pilotDao.deletePilot((long) 3);
		Assert.assertEquals(3, pilotDao.getPilots().size());	
		
		pilotDao.modifyPwd((long) 0,"apple");
		pilotDao.modifyUsername((long) 0,"banana");
		
		pilotDao.getPilots().get(0).display();
		
		// test login
		Pilot p= pilotDao.Login("banana","apple");
		Assert.assertEquals("Rayan", p.getName());
		
		passengerDao.addPassenger(passenger1);
		passengerDao.addPassenger(passenger2);
		passengerDao.addPassenger(passenger3);
		passengerDao.addPassenger(passenger4);
		passengerDao.addPassenger(passenger5);
		passengerDao.addPassenger(passenger6);
		
		Assert.assertEquals(6,passengerDao.getPassengers().size());
		passengerDao.deletePassenger((long)5);
		Assert.assertEquals(5,passengerDao.getPassengers().size());	
		
		Flight flight1 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 1",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom2",150,37,pilot1.getPilotId(),aircraft1.getTailNumber());	
		Flight flight2 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 1",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom3",30,48,pilot2.getPilotId(),aircraft2.getTailNumber());		
		Flight flight3 = new Flight(new Date(2021,04,16),LocalDateTime.of(2021,04,16,18,20,0), "Aerodrome 1",new Date(2021,04,16),LocalDateTime.of(2021,04,16,20,50,0),"Marseille",150,59,pilot3.getPilotId(),aircraft1.getTailNumber());
		Flight flight4 = new Flight(new Date(2021,04,16),LocalDateTime.of(2021,04,16,15,20,0), "Aerodrome 1",new Date(2021,04,16),LocalDateTime.of(2021,04,16,20,50,0),"Casa",30,59,pilot1.getPilotId(),aircraft1.getTailNumber());

		flightDao.addFlight(flight1);
		flightDao.addFlight(flight2);
		flightDao.addFlight(flight3);
		flightDao.addFlight(flight4);
		
		//test add+remove passenger in a flight
		flightDao.addPassenger((long)0, (long) 0);
		flightDao.addPassenger((long)1, (long) 0);
		flightDao.addPassenger((long)2, (long) 0);
		flightDao.addPassenger((long)3, (long) 0);
		Assert.assertEquals(4, flightDao.getPassengersList((long) 0).size());		

		flightDao.removePassenger((long)2, (long) 0);
		Assert.assertEquals(3, flightDao.getFlights().get(0).getPassengersList().size());
		Assert.assertEquals(3, flightDao.getPassengersList((long) 0).size());
		Assert.assertEquals(37, flightDao.getPrice((long) 0));
		Assert.assertEquals(150, flightDao.getAvailableSeats((long) 0));
		

		
		Reservation resa1=new Reservation(passenger1.getPassengerId(),flight1.getId(),3);
		Reservation resa2=new Reservation(passenger4.getPassengerId(),flight1.getId(),2);
		Reservation resa3=new Reservation(passenger5.getPassengerId(),flight1.getId(),5);
		Reservation resa4=new Reservation(passenger1.getPassengerId(),flight2.getId(),5);
		Reservation resa5=new Reservation(passenger1.getPassengerId(),flight2.getId(),5);	
		Reservation resa6=new Reservation(passenger1.getPassengerId(),flight2.getId(),200);	
		
		// test add reservation
		reservationDao.addReservation(resa1);
		reservationDao.addReservation(resa2);
		reservationDao.addReservation(resa3);
		reservationDao.addReservation(resa4);	
		reservationDao.addReservation(resa6);	
		
		
		Assert.assertEquals(4, flightDao.getFlights().size());
		Assert.assertEquals(2,  flightDao.getFlights(30).size());
		Assert.assertEquals(2,  flightDao.getFlights("2021-04-16 13:30","2021-04-16 23:30","Aerodrome 1").size());
		Assert.assertEquals(2,  flightDao.getFlights(30,50).size());
		Assert.assertEquals(4, reservationDao.getReservations().size());
		Assert.assertEquals((150-(3+5+2)), flightDao.getFlights().get(0).getAvailableSeats());

		passengerDao.addReservation((long)0,(long) 0);
		passengerDao.addReservation((long)0,(long) 3);
		passengerDao.addReservation((long)0,(long) 4);
		passengerDao.getPassengers().get(0).display();
		
		Assert.assertEquals(3, passengerDao.getpassengerBookingList(passenger1.getPassengerId()).size());
		
		//test modify flight
		flightDao.modifyFlight((long)3, "2021-10-04 11:30", "Marsupilami", "2021-10-06 11:30", "Aérodrome de l'eidd");
		
		flightDao.getFlights().get(3).display();
		Assert.assertEquals(1,  flightDao.getFlights("2021-10-04 10:30","2021-10-05 11:30","Marsupilami").size());
		
		// test change number of seats
		reservationDao.changeNumberOfSeats(8, (long) 0);
		Assert.assertEquals((150-(8+5+2)), flightDao.getFlights().get(0).getAvailableSeats());

	}
}