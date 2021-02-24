package fr.abyssia.flymee.models;

public class Pilot extends User {
	public String experience;
	public String qualifications;
	public int flightHours;
	public String phone;

	public Pilot(String experience, String qualifications, int flightHours, String phone) {
		super();
		this.experience = experience;
		this.qualifications = qualifications;
		this.flightHours = flightHours;
		this.phone = phone;
	}

}
