package com.example.jetty_jersey.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Dao.List;
import Models.User;

@Path("")
public class Resource {

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public List<User> getUsers() {
		ArrayList<User> list = new ArrayList<User>();
		User test = new User();
		lits.add(test);
		return list;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user/{id}")
	public User getUser(int userID); {
		User test = new User();
		test.id = userID;
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
