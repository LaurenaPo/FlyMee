package com.flymee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flymee.models.Aircraft;
import com.flymee.models.Flight;

public class AircraftDaoImpl implements AircraftDao {
	PersistenceManagerFactory pmf;
	List<Aircraft> aircraftList;

	public AircraftDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Aircraft> getAircrafts() {
		List<Aircraft> list = null;
		List<Aircraft> detached = new ArrayList<Aircraft>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction(); // ici : retour de tous les aerodromes ? ou par critere de selection ?
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			list = (List<Aircraft>) q.execute();
			detached = (List<Aircraft>) pm.detachCopyAll(list);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	@SuppressWarnings({ "unchecked" })
	public Aircraft getAircraft(int aircraftID) {
		List<Aircraft> ai = null;
		List<Aircraft> detached = new ArrayList<Aircraft>();
		Aircraft resAi;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("private int id");
			q.setFilter("aircraftID == id");
			ai = (List<Aircraft>) q.execute(aircraftID);
			detached = (List<Aircraft>) pm.detachCopyAll(ai);
			resAi = detached.get(0);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return resAi;
	}

	public void addAircraft(Aircraft aircraft) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(aircraft);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public Aircraft updateAircraft(Aircraft air) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Aircraft modif;
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			modif = pm.getObjectById(Aircraft.class, air.getId());
			if (!(modif.getPilot().equals(air.getPilot()))) {
				modif.setPilot(air.getPilot());
			}
			if (!(modif.getModelName().equals(air.getModelName()))) {
				modif.setModelName(air.getModelName());
			}
			if (!(modif.getPlaceNumber() == (air.getPlaceNumber()))) {
				modif.setPlaceNumber(air.getPlaceNumber());
			}
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return modif;
	}

	public void deleteAircraft(int aircraftID) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Aircraft pl = pm.getObjectById(Aircraft.class, aircraftID);
			pm.deletePersistent(pl);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

}
