package omdb;

import java.sql.*;

public class readMovie {

	public static void main(String[] args) {

		try {
			// Establishing connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");

			// statement creation
			Statement myStat = myConn.createStatement();

			// SQL query creation
			String sqlQuery = "SELECT movie_id, english_name, native_name, year_made"
					+ "FROM movies";
//					+ "LEFT JOIN movie_data md on m.movie_id = md.movie_id "
//					+ "WHERE md.movie_id = '3'";

			// SQL query execution
			ResultSet myRs = myStat.executeQuery(sqlQuery);
			int movieId = myRs.getInt("movie_id");
			System.out.println("movie_id: " + movieId);

			// process the results
			System.out.println("Passed SQL query");
			
			while (myRs.next()) {
				System.out.println(myRs.getInt("m.movie_id") + ", " + myRs.getString("m.native_name") + ", "
						+ myRs.getString("m.english_name") + ", " + myRs.getInt("m.year_made"));
//				System.out.println(myRs.getString("md.tag_line") + ", "
//						+ myRs.getString("md.language") + ", " + myRs.getString("md.country") + ", " + myRs.getString("md.genre")
//						+ ", " + myRs.getString("md.plot"));

			}

			// close the connection
			myConn.close();
		}

		catch (Exception exc) {

			exc.printStackTrace();
		}
	}

}
