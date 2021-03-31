package fr.abyssia.flymee.models;

public class Aircraft {
	protected int id;
	protected Pilot pilot;
	protected String modelName;
	protected int placeNumber;

	public Aircraft(int id, Pilot pilot, String modelName, int i) {
		this.id = id;
		this.pilot = pilot;
		this.modelName = modelName;
		this.placeNumber = i;
	}
	
	public Aircraft() {
	}

}
