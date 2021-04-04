//Maamoun
package omdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SongPeople {
	private int songID;
	private int peopleID;
	private String role;
	
	
	public SongPeople(int songID, int peopleID, String role ) {
		this.songID = songID;
		this.peopleID = peopleID;
		this.role = role;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			String sqlQuery = "INSERT INTO people_song VALUES (" + songID + ", " + peopleID + ", " + role ")";
			Statement msStat2 = conn.createStatement();
			msStat2.executeUpdate(sqlQuery);
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
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
	

}
