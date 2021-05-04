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

import fr.abyssia.flymee.dao.FlightDao;
import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.User;

@Path("/flights")
public class RessourceFlight {
	private FlightDao flights;

	public RessourceFlight(FlightDao flights) {
		this.flights = flights;

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
	public void addFlight(Flight flight) {
		this.flights.addFlight(flight);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight/")
	public Flight updateFlight(@PathParam("flight") Flight flight) {
		return this.flights.updateFlight(flight);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void deleteFlight(@PathParam("id") int flightID) {
		this.flights.deleteFlight(flightID);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/users")
	public List<User> getPassengers(@PathParam("id") int flightID) {
		return this.flights.getPassengers(flightID);
	}

}
