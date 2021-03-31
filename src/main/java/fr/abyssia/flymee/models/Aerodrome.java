package fr.abyssia.flymee.models;

public class Aerodrome {
	protected int id;
	protected String country;
	protected String town;
	protected String name;

	public Aerodrome(int id, String country, String town, String name) {
		this.id = id;
		this.country = country;
		this.town = town;
		this.name = name;
	}

}
