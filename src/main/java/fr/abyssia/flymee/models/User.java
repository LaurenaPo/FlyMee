package fr.abyssia.flymee.models;

import java.time.LocalDate;

public class User {
	protected int id;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected LocalDate dateOfBirth;
	protected String password;
	protected String profilePicture;
	protected String description;
	protected int weight;

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
