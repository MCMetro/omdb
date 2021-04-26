//Maamoun
package omdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SongPeople {
	private int songID;
	private int peopleID;
	private String role;
	private String stageName;
	private String firstName;
	private String lastName;
	
	
	public SongPeople(int songID, int peopleID, String role ) {
		this.songID = songID;
		this.peopleID = peopleID;
		this.role = role;
	}
	public SongPeople(int songID, int peopleID, String role, String stageName, String firstName, String lastName ) {
		this.songID = songID;
		this.peopleID = peopleID;
		this.role = role;
		this.stageName = stageName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//songID getter method
	public int getSongID() {
		return songID;
	}
	//peopleID getter method 
	public int getPeopleID() {
		return peopleID;
	}
	
	//role getter method
	public String getRole() {
		return role;
	}
	public String getStageName() {
		return this.stageName;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String toString() {
		String spString = "Song ID: " + this.getSongID() + ", People ID: " + this.getPeopleID() +
				", Stage Name: " + this.getStageName() + ", First Name: " + this.getFirstName() +
				", Last Name: " + this.getLastName();
		return spString;
	}
	

}
