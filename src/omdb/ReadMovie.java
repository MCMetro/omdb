package omdb;

import java.sql.*;

public class ReadMovie {

	// TODO: Change to a boolean for true false and error handling.
	public static void main(String[] args) {

		try {
			// Establishing connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");

			// statement creation
			Statement myStat = myConn.createStatement();

			// SQL query creation
			String sqlQuery = "select m.movie_id, m.english_name, m.native_name, m.year_made, md.tag_line, md.movie_id, md.language, md.country, md.genre, md.plot\r\n"
					+ "FROM movies m\r\n" + "LEFT JOIN movie_data md on m.movie_id = md.movie_id\r\n"
					+ "WHERE m.movie_id = '1'";

			// SQL query execution
			ResultSet myRs = myStat.executeQuery(sqlQuery);

			// Extract Necessary Data
			myRs.next();
			int movieId = myRs.getInt("movie_id");
			String englishName = myRs.getString("english_name");
			String nativeName = myRs.getString("native_name");
			int yearMade = myRs.getInt("year_made");
			String country = myRs.getString("country");
			String genre = myRs.getString("language");
			String plot = myRs.getString("plot");
			String tagLine = myRs.getString("tag_line");

			// process the results
			System.out.println("Movie ID: " + movieId);
			System.out.println("English Name: " + englishName);
			System.out.println("Native Name: " + nativeName);
			System.out.println("Year Made: " + yearMade);
			System.out.println("Country: " + country);
			System.out.println("Genre: " + genre);
			System.out.println("Plot: " + plot);
			System.out.println("Tagline: " + tagLine);

			// close the connection
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
