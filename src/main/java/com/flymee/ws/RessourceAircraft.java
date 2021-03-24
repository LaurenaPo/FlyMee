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

import com.flymee.dao.AircraftDao;
import com.flymee.models.Aircraft;

@Path("/aircrafts")
public class RessourceAircraft {
	private AircraftDao aircrafts;

	public RessourceAircraft(AircraftDao aircrafts) {
		this.aircrafts = aircrafts;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aircraft> getAircrafts() {
		return this.aircrafts.getAircrafts();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Aircraft getAircraft(@PathParam("id") int aircraftID) {
		return this.aircrafts.getAircraft(aircraftID);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Aircraft createAircraft() {
		return this.aircrafts.createAircraft();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Aircraft updateAircraft(@PathParam("id") int aircraftID) {
		return this.aircrafts.updateAircraft(aircraftID);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public boolean deleteAircraft(@PathParam("id") int aircraftID) {
		return this.aircrafts.deleteAircraft(aircraftID);
	}
	
}
