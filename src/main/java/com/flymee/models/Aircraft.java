package com.flymee.models;

public class Aircraft {
	public int id;
	public Pilot pilot;
	public String modelName;
	public int placeNumber;

	public Aircraft(int id, Pilot pilot, String modelName, int i) {
		this.id = id;
		this.pilot = pilot;
		this.modelName = modelName;
		this.placeNumber = i;
	}
	
	public Aircraft() {
	}

}
