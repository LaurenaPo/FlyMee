package fr.abyssia.flymee.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.abyssia.flymee.models.User;

@Path("")
public class Ressource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public List<User> getUsers() {
		ArrayList<User> list = new ArrayList<User>();
		User test = new User();
		list.add(test);
		return list;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user/{id}")
	public User getUser(int userID) {
		User test = new User();
		//test.id = userID;
		return test;
	} 

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/user")
	public User postUser() {
		User test = new User();
		return test;
	}
}
