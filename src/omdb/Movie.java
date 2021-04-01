package omdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Movie {
	private int movieID;
	private String nativeName;
	private String englishName;
	private int yearMade;
	private String country;
	private String genre;
	private String language;
	private String plot;
	private String tagLine;
	
	public Movie(int movieID, String englishName, String nativeName, int year) {
		this.movieID = movieID;
		this.englishName = englishName;
		this.nativeName = nativeName;
		this.yearMade = year;
		try {
			// STEP 1: Start Connection to the Database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			Statement stmt = null;
			// STEP 2: Execute a query
			stmt = conn.createStatement();
			// STEP 3: Insert Values
			String sql = "INSERT INTO movies " + "VALUES (" + movieID + ", '" + englishName + "', '" + nativeName
					+ "', " + year + ")";
			stmt.executeUpdate(sql);
			// STEP 4: Close the connection
			conn.close();
			// STEP 5: Catch Errors
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getNativeName() {
		return nativeName;
	}

	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public int getYearMade() {
		return yearMade;
	}

	public void setYearMade(int yearMade) {
		this.yearMade = yearMade;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}
	


}
