package omdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	public Movie() {
		// TODO Auto-generated constructor stub
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
	
//	public void updateMovie(int movieID, String englishName, int yearMade) {
//		String sqlUpdate = "UPDATE movies " + "SET english_name = ?, year_made = ? " + "WHERE movie_id = ?";
//		
//		// create connection to database
//		// PreparedStatement allows for repeated use of mysql statement if needed.
//		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
//				PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
//
//			// prepare data for update
//			pstmt.setString(1, englishName);
//			pstmt.setInt(2, yearMade);
//			pstmt.setInt(3, movieID);
//
//			// print out rows affected
//			int rowAffected = pstmt.executeUpdate();
//			System.out.println("Movie Updated Successfully!");
//			System.out.println(String.format("Row affected %d", rowAffected));
//
//			conn.close();
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		}
//	}
//
}
