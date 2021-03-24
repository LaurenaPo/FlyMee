package com.flymee.models;

import java.time.LocalDate;

public class Pilot extends User {
	public String experience;
	public String qualifications;
	public int flightHours;
	public String phone;

	public Pilot(int id, String firstName, String lastName, String email, LocalDate dateOfBirth, String password,
			String profilePicture, String description, int weight, String experience, String qualifications, int flightHours, String phone) {
		super(id, firstName, lastName, email, dateOfBirth, password, profilePicture, description, weight);
		this.experience = experience;
		this.qualifications = qualifications;
		this.flightHours = flightHours;
		this.phone = phone;
	}
	
	public Pilot() {
	}

}
