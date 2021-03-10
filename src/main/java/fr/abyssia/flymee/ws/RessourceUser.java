package fr.abyssia.flymee.ws;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.abyssia.flymee.models.Aircraft;
import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.Pilot;
import fr.abyssia.flymee.models.User;

@Path("/users")
public class RessourceUser {
	List<User> userList;
	List<Flight> flightList;

	public RessourceUser() {
		this.userList = new ArrayList<User>();
		User test1 = new User(1, "Jean", "Dupont", "jean.dupont@gmail.com", LocalDate.of(2000, 1, 1), "1234");
		User test2 = new User(2, "Marine", "Dupont", "marine.dupont@gmail.com", LocalDate.of(2000, 1, 2), "1234");
		User test3 = new User(3, "Marc", "Dupont", "marc.dupont@gmail.com", LocalDate.of(2000, 1, 3), "1234");
		this.userList.add(test1);
		this.userList.add(test2);
		this.userList.add(test3);
		
		this.flightList = new ArrayList<Flight>();
		Flight flight1 = new Flight(1, "NCE", "ORY", new GregorianCalendar(2021, 4, 4, 17, 30),
				new GregorianCalendar(2021, 4, 4, 19, 00), 4, 2, new Pilot(), this.userList, new Aircraft(), 81f,
				"Nice");
		Flight flight2 = new Flight(2, "ORY", "NCE", new GregorianCalendar(2021, 4, 10, 17, 30),
				new GregorianCalendar(2021, 4, 10, 19, 00), 4, 2, new Pilot(), this.userList, new Aircraft(), 87f,
				"Châtelet");
		this.flightList.add(flight1);
		this.flightList.add(flight2);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userList;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public User getUser(@PathParam("id") int userID) {
		for (User user : userList) {
			if (user.id == userID) {
				return user;
			}
		}
		return null;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public User createUser() {
		User newUser = new User(4, "Oak", "Cacahouète", "oak.cacahouete@gmail.com", LocalDate.of(1999, 10, 17), "1234");
		userList.add(newUser);
		;
		return newUser;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public User updateUser(@PathParam("id") int userID) {
		for (User user : userList) {
			if (user.id == userID) {
				userList.remove(user);
				User userUpdated = new User(userID, "Kao", "Otoko", "kao.otoko@gmail.com", LocalDate.of(1999, 10, 17),
						"1234");
				userList.add(userUpdated);
				return userUpdated;
			}
		}
		return null;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public boolean deleteUser(@PathParam("id") int userID) {
		for (User user : userList) {
			if (user.id == userID) {
				userList.remove(user);
				return true;
			}
		}
		return false;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/flights")
	public List<Flight> getFlights(@PathParam("id") int userID) {
		for (User user : userList) {
			if (user.id == userID) {
				return this.flightList ;
			}
		}
		return new ArrayList<Flight>();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/flights/{flight-id}")
	public boolean reservedFlight(@PathParam("id") int userID, @PathParam("flight-id") int flightID) {
		for (User user : this.userList) {
			if (user.id == userID) {
				for (Flight flight: this.flightList) {
					if (flight.id == flightID) {
						flight.passengerList.add(user);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public boolean login() {
		return true;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/logout")
	public boolean logout() {
		return true;
	}
	
	

}
