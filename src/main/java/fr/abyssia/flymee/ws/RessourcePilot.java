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

import fr.abyssia.flymee.dao.PilotDao;
import fr.abyssia.flymee.models.Aircraft;
import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.Pilot;
import fr.abyssia.flymee.models.User;

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
	public Pilot createPilot() {
		return this.pilots.createPilot();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public User updatePilot(@PathParam("id") int pilotID) {
		return this.pilots.updatePilot(pilotID);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public boolean deletePilot(@PathParam("id") int pilotID) {
		return this.pilots.deletePilot(pilotID);
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
