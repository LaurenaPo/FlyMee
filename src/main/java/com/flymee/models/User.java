package com.flymee.models;

import java.time.LocalDate;

public class User {
	public int id;
	public String firstName;
	public String lastName;
	public String email;
	public LocalDate dateOfBirth;
	public String password;
	public String profilePicture;
	public String description;
	public int weight;

	public User(int id, String firstName, String lastName, String email, LocalDate dateOfBirth, String password,
			String profilePicture, String description, int weight) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.profilePicture = profilePicture;
		this.description = description;
		this.weight = weight;
	}

	public User(int id, String firstName, String lastName, String email, LocalDate dateOfBirth, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
	}

	public User() {
	}

}
