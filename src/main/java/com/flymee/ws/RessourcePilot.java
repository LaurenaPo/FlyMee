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

import com.flymee.dao.PilotDao;
import com.flymee.models.Aircraft;
import com.flymee.models.Flight;
import com.flymee.models.Pilot;
import com.flymee.models.User;

@Path("/pilots")
public class RessourcePilot {
	private PilotDao pilots;

	public RessourcePilot(PilotDao pilots) {
		this.pilots = pilots;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pilot> getPilots() {
		return this.pilots.getPilots();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Pilot getPilot(@PathParam("id") int pilotID) {
		return this.pilots.getPilot(pilotID);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void createPilot(Pilot pilot) {
		this.pilots.addPilot(pilot);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public User updatePilot(@PathParam("id") Pilot pilot) {
		return this.pilots.updatePilot(pilot);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void deletePilot(@PathParam("id") int pilotID) {
		this.pilots.deletePilot(pilotID);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/flights")
	public List<Flight> getFlights(@PathParam("id") int pilotID) {
		return this.pilots.getFlights(pilotID);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/aircrafts")
	public List<Aircraft> getAircrafts(@PathParam("id") int pilotID) {
		return this.pilots.getAircrafts(pilotID);
	}

}
