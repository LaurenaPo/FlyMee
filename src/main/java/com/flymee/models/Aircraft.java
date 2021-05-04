package com.flymee.models;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Aircraft {
	private int id;
	protected Pilot pilot;
	protected String modelName;
	protected int placeNumber;

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getPlaceNumber() {
		return placeNumber;
	}

	public void setPlaceNumber(int placeNumber) {
		this.placeNumber = placeNumber;
	}

	public Aircraft(int id, Pilot pilot, String modelName, int i) {
		this.setId(id);
		this.pilot = pilot;
		this.modelName = modelName;
		this.placeNumber = i;
	}

	public Aircraft() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
