package fr.abyssia.flymee.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.abyssia.flymee.models.Aircraft;
import fr.abyssia.flymee.models.Pilot;

@Path("/aircrafts")
public class RessourceAircraft {
	List<Aircraft> aircraftList;
	
	public RessourceAircraft() {
		this.aircraftList = new ArrayList<Aircraft>();
		
		Aircraft test1 = new Aircraft(1,new Pilot(), "B74f", 4);
		Aircraft test2 = new Aircraft(2,new Pilot(), "B75f", 3);
		Aircraft test3 = new Aircraft(3,new Pilot(), "B76f", 2);
		aircraftList.add(test1);
		aircraftList.add(test2);
		aircraftList.add(test3);		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aircraft> getAircrafts() {
		return this.aircraftList;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Aircraft getAircraft(@PathParam("id") int aircraftID) {
		for (Aircraft aircraft : aircraftList) {
			if (aircraft.id == aircraftID) {
				return aircraft;
			}
		}
		return null;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Aircraft createAircraft() {
		Aircraft newAircraft = new Aircraft(4,new Pilot(), "B77f", 5);
		aircraftList.add(newAircraft);
		return newAircraft;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Aircraft updateAircraft(@PathParam("id") int aircraftID) {
		for (Aircraft aircraft : aircraftList) {
			if (aircraft.id == aircraftID) {
				aircraftList.remove(aircraft);
				Aircraft aircraftUpdated = new Aircraft(aircraftID,new Pilot(), "B78f", 3);
				aircraftList.add(aircraftUpdated);
				return aircraftUpdated;
			}
		}
		return null;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public boolean deleteAircraft(@PathParam("id") int aircraftID) {
		for (Aircraft aircraft : aircraftList) {
			if (aircraft.id == aircraftID) {
				aircraftList.remove(aircraft);
				return true;
			}
		}
		return false;
	}
	
}
