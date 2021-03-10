package fr.abyssia.flymee.ws;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
import fr.abyssia.flymee.models.Flight;
import fr.abyssia.flymee.models.Pilot;
import fr.abyssia.flymee.models.User;

@Path("/pilots")
public class RessourcePilot {
	List<Pilot> pilotList;
	List<Flight> flightList;
	
	public RessourcePilot() {
		this.pilotList = new ArrayList<Pilot>();
		Pilot pilot1 = new Pilot(1, "Luna", "Blanc", "luna.blanc@gmail.com", LocalDate.of(2000, 4, 28), "1234", null, null, 55, null, null, 40, null);
		Pilot pilot2 = new Pilot(2, "Marc", "Dupont", "marc.dupont@gmail.com", LocalDate.of(1999, 10, 17), "1234", null, null, 60, null, null, 100, null);
		this.pilotList.add(pilot1);
		this.pilotList.add(pilot2);
		
		this.flightList = new ArrayList<Flight>();
		Flight flight1 = new Flight(1, "NCE", "ORY", new GregorianCalendar(2021, 4, 4, 17, 30),
				new GregorianCalendar(2021, 4, 4, 19, 00), 4, 2, pilot1, new ArrayList<User>(), new Aircraft(), 81f,
				"Nice");
		Flight flight2 = new Flight(2, "ORY", "NCE", new GregorianCalendar(2021, 4, 10, 17, 30),
				new GregorianCalendar(2021, 4, 10, 19, 00), 4, 2, pilot1, new ArrayList<User>(), new Aircraft(), 87f,
				"Châtelet");
		this.flightList.add(flight1);
		this.flightList.add(flight2);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pilot> getPilots() {
		return pilotList;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Pilot getPilot(@PathParam("id") int pilotID) {
		for (Pilot pilot : pilotList) {
			if (pilot.id == pilotID) {
				return pilot;
			}
		}
		return null;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Pilot createPilot() {
		Pilot newPilot = new Pilot(3, "Julie", "Lou", "julie.lou@gmail.com", LocalDate.of(1995, 5, 14), "1234", null, null, 57, null, null, 280, null);
		pilotList.add(newPilot);
		return newPilot;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public User updatePilot(@PathParam("id") int pilotID) {
		for (Pilot pilot : pilotList) {
			if (pilot.id == pilotID) {
				pilotList.remove(pilot);
				Pilot pilotUpdated = new Pilot(pilotID, "Julie", "Lou", "julie.lou@gmail.com", LocalDate.of(1995, 5, 15), "1234", null, null, 57, null, null, 280, null);
				pilotList.add(pilotUpdated);
				return pilotUpdated;
			}
		}
		return null;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public boolean deletePilot(@PathParam("id") int pilotID) {
		for (Pilot pilot : pilotList) {
			if (pilot.id == pilotID) {
				pilotList.remove(pilot);
				return true;
			}
		}
		return false;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/flights")
	public List<Flight> getFlights(@PathParam("id") int pilotID) {
		List<Flight> result = new ArrayList<Flight>();
		for (Pilot pilot : pilotList) {
			if (pilot.id == pilotID) {
				for (Flight flight: flightList) {
					if (flight.pilot == pilot) {
						result.add(flight);
					}
				}
			}
		}
		return result;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/aircrafts")
	public List<Aircraft> getAircrafts(@PathParam("id") int pilotID) {
		List<Aircraft> aircraftList = new ArrayList<Aircraft>();
		for (Pilot pilot : pilotList) {
			if (pilot.id == pilotID) {
				Aircraft aircraft1 = new Aircraft(1, pilot, "", 4);
				Aircraft aircraft2 = new Aircraft(2, pilot, "", 5);
				aircraftList.add(aircraft1);
				aircraftList.add(aircraft2);
			}
		}
		return aircraftList	;
	}
	
}
