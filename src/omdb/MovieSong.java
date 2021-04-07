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
	
	
