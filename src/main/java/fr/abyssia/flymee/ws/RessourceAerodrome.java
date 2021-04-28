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

import fr.abyssia.flymee.dao.AerodromeDao;
import fr.abyssia.flymee.models.Aerodrome;
import fr.abyssia.flymee.models.Flight;

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
	public void addAerodrome(Aerodrome aero) {
		this.aerodromes.addAerodrome(aero);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Aerodrome updateAerodrome(@PathParam("id") Aerodrome aero) {
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
