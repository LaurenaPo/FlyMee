package fr.abyssia.flymee.models;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Aerodrome {
	private int id;
	protected String country;
	protected String town;
	protected String name;

	public Aerodrome(int id, String country, String town, String name) {
		this.setId(id);
		this.country = country;
		this.town = town;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
