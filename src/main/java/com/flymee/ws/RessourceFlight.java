package com.flymee.ws;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flymee.dao.FlightStubDao;
import com.flymee.models.Flight;
import com.flymee.models.User;

@Path("/flights")
public class RessourceFlight {
	/*
	 * private FlightDao flights;
	 * 
	 * public RessourceFlight(FlightDao flights) { this.flights = flights;
	 * 
	 * }
	 */

	private FlightStubDao flights;

	public RessourceFlight() {
		this.flights = new FlightStubDao();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> getFlights() {
		return this.flights.getFlights();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Flight getFlight(@PathParam("id") int flightID) {
		return this.flights.getFlight(flightID);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Flight createFlight() {
		return this.flights.createFlight();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Flight updateFlight(@PathParam("id") int flightID) {
		return this.flights.updateFlight(flightID);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public boolean deleteFlight(@PathParam("id") int flightID) {
		return this.flights.deleteFlight(flightID);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/users")
	public List<User> getPassengers(@PathParam("id") int flightID) {
		return this.flights.getPassengers(flightID);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{aerodrome}/{date}")
	public List<Flight> ListOfFlight(@PathParam("aerodrome") String aerodrome, @PathParam("date") String date) {
		return this.flights.getSomeFlights(aerodrome, date);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search/{aerodrome}")
	public List<Flight> ListOfFlightWithNoDate(@PathParam("aerodrome") String aerodrome) {
		return this.flights.getSomeFlights(aerodrome, "1900-00-00");
	}

}
