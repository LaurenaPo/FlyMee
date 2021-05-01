package fr.abyssia.flymee.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class DaoFactory {
	private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlyMee_DO");
	
	// on appelle les DAO par les ws quand necessaires 
	public static AerodromeDao getAerodromeDao() {
		return new AerodromeDaoImpl(pmf);
	}

	public static FlightDao getFlightDao() {
		return new FlightDaoImpl(pmf);
	}
	
	public static PilotDao getPilotDao() {
		return new PilotDaoImpl(pmf);
	}
	
	public static UserDao getUserDao() {
		return new UserDaoImpl(pmf);
	}
	
	public static AircraftDao getAircraftDao() {
		return new AircraftDaoImpl(pmf);
	}
}