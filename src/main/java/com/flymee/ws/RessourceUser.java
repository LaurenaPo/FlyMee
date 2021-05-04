package com.flymee.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flymee.dao.DaoFactory;
import com.flymee.dao.UserDao;
import com.flymee.models.Flight;
import com.flymee.models.Pilot;
import com.flymee.models.User;

@Path("/users")
public class RessourceUser {
	private UserDao users;
	
	public RessourceUser() {
        this.users = DaoFactory.getUserDao();
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
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/signup")
	public void createUser(User user) {
		this.users.addUser(user);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/signup")
	public User updateUser(User user) {
		return this.users.updateUser(user);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void deleteUser(@PathParam("id") int userID) {
		this.users.deleteUser(userID);
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/logout")
	public boolean logout() {
		return this.users.logout();
	}

}
