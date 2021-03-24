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

import com.flymee.dao.AerodromeDao;
import com.flymee.models.Aerodrome;
import com.flymee.models.Flight;

@Path("/aerodromes")
public class RessourceAerodrome {
	private AerodromeDao aerodromes;

	public RessourceAerodrome(AerodromeDao aerodromes) {
		this.aerodromes = aerodromes;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aerodrome> getAerodromes() {
		return this.aerodromes.getAerodromes();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Aerodrome getAerodrome(@PathParam("id") int aerodromeID) {
		return this.aerodromes.getAerodrome(aerodromeID);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Aerodrome createAerodrome() {
		return this.aerodromes.createAerodrome();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Aerodrome updateAerodrome(@PathParam("id") int aerodromeID) {
		return this.aerodromes.updateAerodrome(aerodromeID);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public boolean deleteAerodrome(@PathParam("id") int aerodromeID) {
		return this.aerodromes.deleteAerodrome(aerodromeID);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/departure")
	public List<Flight> getFlightsDeparture(@PathParam("id") int aerodromeID) {
		return this.aerodromes.getFlightsDeparture(aerodromeID);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/arrival")
	public List<Flight> getFlightsArrival(@PathParam("id") int aerodromeID) {
		return this.aerodromes.getFlightsArrival(aerodromeID);
	}
}
