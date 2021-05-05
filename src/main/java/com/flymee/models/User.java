package com.flymee.models;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class User {

	private int id;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;
	protected String profilePicture;
	protected String description;
	protected int weight;

	public User(int id, String firstName, String lastName, String email, String password, String profilePicture,
			String description, int weight) {
		this.setId(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
		this.description = description;
		this.weight = weight;
	}

	public User(int id, String firstName, String lastName, String email, String password) {
		this.setId(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
