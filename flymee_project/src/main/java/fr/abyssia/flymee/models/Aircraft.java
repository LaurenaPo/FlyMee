package fr.abyssia.flymee.models;

public class Aircraft {
	public int id;
	public Pilot pilot;
	public String modelName;
	public byte placeNumber;

	public Aircraft(int id, Pilot pilot, String modelName, byte placeNumber) {
		this.id = id;
		this.pilot = pilot;
		this.modelName = modelName;
		this.placeNumber = placeNumber;
	}

}
