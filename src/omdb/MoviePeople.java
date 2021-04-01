package omdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MoviePeople {
	private int movieID;
	private int peopleID;
	private String role;
	private String screenName;
	
	public MoviePeople(int movieID, int peopleID, String role, String screenName) {
		this.movieID = movieID;
		this.peopleID = peopleID;
		this.role = role;
		this.screenName = screenName;

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			String sqlQuery = "INSERT INTO movie_people VALUES (" + movieID + ", " + peopleID + ", "
					+ "'" + role + "', '" + screenName + "')";
			Statement msStat2 = conn.createStatement();
			msStat2.executeUpdate(sqlQuery);
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public int getPeopleID() {
		return peopleID;
	}
	public void setPeopleID(int peopleID) {
		this.peopleID = peopleID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	

}
