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
import com.flymee.dao.AerodromeStubDao;
import com.flymee.models.Aerodrome;
import com.flymee.models.Flight;

@Path("/aerodromes")
public class RessourceAerodrome {
	private AerodromeDao aerodromes;

	public RessourceAerodrome(AerodromeDao aerodromes) {
		this.aerodromes = aerodromes;
	}

	public RessourceAerodrome() {
		this.aerodromes = new AerodromeStubDao();
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
	public void addAerodrome(Aerodrome aero) {
		this.aerodromes.addAerodrome(aero);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Aerodrome updateAerodrome(Aerodrome aero) {
		return this.aerodromes.updateAerodrome(aero);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void deleteAerodrome(@PathParam("id") int aerodromeID) {
		this.aerodromes.deleteAerodrome(aerodromeID);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}/departure")
	public List<Flight> getFlightsDeparture(@PathParam("name") String name) {
		return this.aerodromes.getFlightsDeparture(name);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/arrival")

	public List<Flight> getFlightsArrival(@PathParam("id") String name) {
		return this.aerodromes.getFlightsArrival(name);
	}
}
