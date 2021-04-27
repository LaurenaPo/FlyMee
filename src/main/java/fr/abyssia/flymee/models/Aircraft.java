package fr.abyssia.flymee.models;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Aircraft {
	private int id;
	protected Pilot pilot;
	protected String modelName;
	protected int placeNumber;

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
