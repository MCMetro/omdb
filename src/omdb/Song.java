package omdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Song {
	private int songID;
	private String lyrics;
	private String theme;
	private String title;
	
	//Constructor method all arguments
	public Song(int songID, String title, String lyrics, String theme) {
		this.songID = songID;
		this.title = title;
		this.lyrics = lyrics;
		this.theme = theme;
	}
	
	//Constructor method with songID and title arguments
	public Song(int songID, String title) {
		this.songID = songID;
		this.title = title;
		//set null and "N/A" values for lyrics and themes respectively
	}
	
	public static boolean checkSong(String title) {
		boolean b = false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			Statement myStat = conn.createStatement();
			
			//songs SQL query; check if title exists in songs table
			String sqlQuery = "SELECT * FROM songs WHERE title = '" + title + "'";
			
			//songs SQL query resultset
			ResultSet songsResults = myStat.executeQuery(sqlQuery);
			
			//check if songsResults query is empty; title does not exist in songs table
			if (!songsResults.next()) {
				b = false;
			} else {
				b = true;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	//method to duplicate apostrophe in title
	public static String addApostrophe(String songTitle, int position) {
		//apostrophe char
		char ch = '\'';
		int len = songTitle.length();
		//create chararray with title length + 1;
	    char[] charArray = new char[len + 1];
	    //copy string values upto index of single quote into the charArray
	    songTitle.getChars(0, position, charArray, 0);
	    //add addition single quote after first single quote
	    charArray[position] = ch;
	    //copy rest of string values into the charArray
	    songTitle.getChars(position, len, charArray, position + 1); 
	    //return string value of the charArray
	    return new String(charArray);
	    //code details found at https://www.baeldung.com/java-add-character-to-string
	}
	
	//method to delete song with songID from database
	public void deleteSong(int songID) {
		try {
			// STEP 1: Start Connection to the Database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			Statement stmt = null;
			// STEP 2: Execute a query
			stmt = conn.createStatement();
			// STEP 3: Delete Values
			String sql = "DELETE FROM songs WHERE song_id = '" + songID + "'";
			stmt.executeUpdate(sql);
			// STEP 4: Close the connection
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Getter for songID from database; returns 0 if song not found
	public int getSongID(String title) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			Statement myStat = conn.createStatement();
			
			//songs SQL query; check if title exists in songs table
			String sqlQuery = "SELECT * FROM songs WHERE title = '" + title + "'";
			
			//songs SQL query resultset
			ResultSet songsResults = myStat.executeQuery(sqlQuery);
			//check if songsResults query is empty; title does not exist in songs table
			if (!songsResults.next()) {
				songID = 0;
			}
			//check if song exists in songs table
			if (songsResults.next()) {
				songID = songsResults.getInt("song_id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return songID;
	}
	
	//Getter for songID
	public int getSongID() {
		return songID;
	}
	
	
	public String getLyrics() {
		return lyrics;
	}

	public String getTheme() {
		return theme;
	}

	public String getTitle() {
		return title;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String toString() {
		String songString = "Song ID: " + this.getSongID() + ", Title: " + this.getTitle();
		return songString;
	}

}
