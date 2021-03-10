package fr.abyssia.flymee.ws;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.abyssia.flymee.dao.UserDao;
import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.User;

@Path("/users")
public class RessourceUser {
	private UserDao users;

	public RessourceUser(UserDao users) {
		this.users = users;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return this.users.getUsers();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public User getUser(@PathParam("id") int userID) {
		return this.users.getUser(userID);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public User createUser() {
		return this.users.createUser();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public User updateUser(@PathParam("id") int userID) {
		return this.users.updateUser(userID);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public boolean deleteUser(@PathParam("id") int userID) {
		return this.users.deleteUser(userID);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/flights")
	public List<Flight> getFlights(@PathParam("id") int userID) {
		return this.users.getFlights(userID);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/flights/{flight-id}")
	public boolean reservedFlight(@PathParam("id") int userID, @PathParam("flight-id") int flightID) {
		return this.users.reservedFlight(userID, flightID);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public boolean login() {
		return this.users.login();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/logout")
	public boolean logout() {
		return this.users.logout();
	}

}
