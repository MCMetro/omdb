package omdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieSong {
	private int movieID;
	private int songID;
	
	public MovieSong(int movieID, int songID) {
		this.movieID = movieID;
		this.songID = songID;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			String sqlQuery = "INSERT INTO movie_song VALUES (" + movieID + ", " + songID + ")";
			Statement msStat2 = conn.createStatement();
			msStat2.executeUpdate(sqlQuery);
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	//movieID getter method
	public int getMovieID() {
		return movieID;
	}
	//songID getter method 
	public int getSongID() {
		return songID;
	}
	
}
	
	
