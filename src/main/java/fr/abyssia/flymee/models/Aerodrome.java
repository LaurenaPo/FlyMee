package fr.abyssia.flymee.models;

public class Aerodrome {
	public int id;
	public String country;
	public String town;
	public String name;

	public Aerodrome(int id, String country, String town, String name) {
		this.id = id;
		this.country = country;
		this.town = town;
		this.name = name;
	}

}
