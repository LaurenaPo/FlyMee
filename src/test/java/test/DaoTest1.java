package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
import com.flymee.dao.UserDaoImpl;
import com.flymee.dao.DaoFactory;
import com.flymee.models.Aerodrome;
import com.flymee.models.Aircraft;
import com.flymee.models.Flight;
import com.flymee.models.Pilot;
import com.flymee.models.User;


class DaoTest1 {

	@SuppressWarnings({ "unused" })
	@Test
	public void test() {
		FlightDao fdi = DaoFactory.getFlightDao();
		AerodromeDao adi = DaoFactory.getAerodromeDao();
		AircraftDao aidi = DaoFactory.getAircraftDao();
		UserDao udi = DaoFactory.getUserDao();
		PilotDao pdi = DaoFactory.getPilotDao();
		
		Pilot p1 = new Pilot(1, "Jean", "Michel","jm@mail.fr", LocalDate.of(1950, 10, 10),"mdp", "photo","pilote chevronne",85, "20 ans", "licence tourisme", 450, "0605040302");
		Pilot p2 = new Pilot(2, "Jean", "Francois","jf@mail.fr", LocalDate.of(1950, 2, 10),"mdp", "photo","pilote philanthrope",85, "2 ans", "licence 4", 21, "0605050302");
		Pilot p3 = new Pilot(4, "Jean", "Mouloud","jmou@mail.fr", LocalDate.of(1950, 1, 10),"mdp", "photo","pirate de l'air",72, "13 ans", "licence tourisme", 202, "0605040303");
		
		User u1 = new User(1, "Jean", "Truc","jt@mail.fr", LocalDate.of(1990, 10, 10),"mdp");
		User u2 = new User(2, "Machin", "Truc","mt@mail.fr", LocalDate.of(1991, 10, 10),"mdp");
		User u3 = new User(3, "Fred", "Truc","ft@mail.fr", LocalDate.of(1980, 10, 10),"mdp");
		User u4 = new User(4, "Pierre", "Pierre","pp@mail.fr", LocalDate.of(1900, 10, 10),"mdp");
		User u5 = new User(5, "Madame", "Monsieur","mm@mail.fr", LocalDate.of(1978, 10, 10),"mdp");
		
		
		Aircraft aircraft1 =new Aircraft(1, p1, "Cessna 340", 4);
		Aircraft aircraft2 =new Aircraft(2, p3, "Cessna 320", 2);
		
		Aerodrome aero1 = new Aerodrome(1, "France", "Marseille", "boulodrome");
		Aerodrome aero2 = new Aerodrome(2, "Italie", "Roma", "Linguine");
		Aerodrome aero3 = new Aerodrome(3, "France", "Lille", "rue2lasoif");
		Aerodrome aero4 = new Aerodrome(4, "Espagne", "Levante", "Hacienda");
		Aerodrome aero5 = new Aerodrome(5, "France", "Paris", "MCI 2-0 PSG");

		Flight f1 = new Flight(1, aero1, aero1, LocalDateTime.of(2021, 6, 6, 10, 10),LocalDateTime.of(2021, 6, 22, 13, 10), 4, 2, p1, List.of(u1, u2), aircraft1, 45.0, "sur le vieux port");
		Flight f2 = new Flight(2, aero2, aero1, LocalDateTime.of(2021, 6, 6, 10, 10),LocalDateTime.of(2021, 6, 22, 15, 10), 4, 1, p1, List.of(u1, u2, u3), aircraft1, 45.0, "piazza d'espagna");
		Flight f3 = new Flight(3, aero3, aero5, LocalDateTime.of(2021, 5, 6, 8, 0),LocalDateTime.of(2021, 5, 6, 9, 10), 2, 2, p3, List.of(u1, u2), aircraft2, 45.0, "gare de Lille");
		
		fdi.addFlight(f1);
		fdi.addFlight(f2);
		fdi.addFlight(f3);
		Assert.assertEquals(3, fdi.getFlights().size());
		fdi.deleteFlight(3);
		Assert.assertEquals(2, fdi.getFlights().size());
		
		fdi.updateFlight(new Flight(1, aero1, aero1, LocalDateTime.of(2021, 6, 22, 10, 10),LocalDateTime.of(2021, 6, 22, 13, 10), 4, 2, p1, List.of(u1, u2), aircraft1, 45.0, "sur le vieux port"));
		
		System.out.print(f1.getTimeDeparture());
		
		
			
		
		aidi.addAircraft(aircraft1);
		aidi.addAircraft(aircraft2);
		Assert.assertEquals(2, aidi.getAircrafts().size());
		aidi.deleteAircraft(2);
		Assert.assertEquals(1, aidi.getAircrafts().size());	
		
		pdi.addPilot(p1);
		pdi.addPilot(p2);
		pdi.addPilot(p3);
		Assert.assertEquals(3, pdi.getPilots().size());
		pdi.deletePilot(2);
		Assert.assertEquals(2, pdi.getPilots().size());	
		
		pdi.updatePilot(new Pilot(1, "Jean", "Michel","jm@mail.fr", LocalDate.of(1950, 10, 10),"mdp", "photo","pilote avec vertige",85, "20 ans", "licence tourisme", 450, "0605040302"));
		
		System.out.print(pdi.getPilots().get(0).getDescription());
		
	
		
		udi.addUser(u1);
		udi.addUser(u2);
		udi.addUser(u3);
		udi.addUser(u4);
		udi.addUser(u5);
		
		Assert.assertEquals(5,udi.getUsers().size());
		udi.deleteUser(2);
		Assert.assertEquals(5,udi.getUsers().size());	
		
		
		fdi.addPassenger(1, 3);
		Assert.assertEquals(3,f1.getPassengerList().size());
		Assert.assertEquals(false, fdi.addPassenger(1, 1));
		fdi.addPassenger(3, 5);
		Assert.assertEquals(false, fdi.addPassenger(3, 5));

		fdi.cancelPassenger(1, 3);
		Assert.assertEquals(2, f1.getPassengerList().size());

	}

}
