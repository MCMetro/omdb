package omdb;

import java.sql.*;

public class MovieDriver {

// TODO: Add error handling (change return types to boolean?)

	public static void updateMovie(int movieID, String englishName, int yearMade) {
		String sqlUpdate = "UPDATE movies " + "SET english_name = ?, year_made = ? " + "WHERE movie_id = ?";

		// Set local variables to user input data.
		int id = movieID;
		String movie_name = englishName;
		int movie_year = yearMade;
		// create connection to database
		// PreparedStatement allows for repeated use of mysql statement if needed.
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
				PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

			// prepare data for update
			pstmt.setString(1, movie_name);
			pstmt.setInt(2, movie_year);
			pstmt.setInt(3, id);

			// print out rows affected
			int rowAffected = pstmt.executeUpdate();
			System.out.println("Movie Updated Successfully!");
			System.out.println(String.format("Row affected %d", rowAffected));

			conn.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void createMovie(int movieID, String englishName, String nativeName, int year) {
		try {
			// STEP 1: Start Connection to the Database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			System.out.println("Connected database successfully...");
			Statement stmt = null;
			// STEP 2: Execute a query
			System.out.println("Inserting new movie into the movie omdb.movies...");
			stmt = conn.createStatement();
			// STEP 3: Insert Values
			String sql = "INSERT INTO movies " + "VALUES (" + movieID + ", '" + englishName + "', '" + nativeName
					+ "', " + year + ")";
			stmt.executeUpdate(sql);
			System.out.println("Movie created successfully!");
			// STEP 4: Close the connection
			conn.close();
			System.out.println("Goodbye!");
			// STEP 5: Catch Errors
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void createSong(int songID, String title) {
		//set null values for lyrics and theme for the moment
		String lyrics = "' '";
		String theme = "' '";
		try {	
			//establish connection with database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			Statement mystmt = conn.createStatement();
			//create insert statement
			String mySql = "INSERT INTO songs VALUES (" + songID + ", " + title + ", " + lyrics + ", " + theme + ");";
			//execute query
			mystmt.executeUpdate(mySql);
			System.out.println("Added song into songs table!");
			//close connection
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void readMovie(int movieID) {
		try {
			// Establishing connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");

			// statement creation
			Statement myStat = myConn.createStatement();

			// SQL query creation
			String sqlQuery = "select m.movie_id, m.english_name, m.native_name, m.year_made, md.tag_line, md.movie_id, md.language, md.country, md.genre, md.plot\r\n"
					+ "FROM movies m\r\n" + "LEFT JOIN movie_data md on m.movie_id = md.movie_id\r\n"
					+ "WHERE m.movie_id = '" + movieID + "'";

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

	public static void deleteMovie(int movieID) {
		try {
			// STEP 1: Start Connection to the Database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			System.out.println("Connected database successfully...");
			Statement stmt = null;
			// STEP 2: Execute a query
			System.out.println("Delete movie from movie database with ID?");
			stmt = conn.createStatement();
			// STEP 3: Delete Values
			String sql = "DELETE FROM movies WHERE movie_id = '" + movieID + "'";
			stmt.executeUpdate(sql);
			System.out.println("Movie deleted successfully!");
			// STEP 4: Close the connection
			conn.close();
			System.out.println("Goodbye!");
			// STEP 5: Catch Errors
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean processMovieSong(String nativeName, int yearMade, int movieID, int songID, String englishName) throws SQLException {
		// Establishing connection to database
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");

		// statement creation
		Statement myStat = myConn.createStatement();

		// SQL query creation
		String sqlQuery = "select native_name, year_made, title, execution_status\n" + "FROM ms_test_data m\r\n"
				+ "WHERE native_name = '" + nativeName + "'\n" + "AND year_made = '" + yearMade + "'";

		// SQL query execution
		ResultSet myRs = myStat.executeQuery(sqlQuery);

		// Gather data results
		myRs.next();
		String nativeNameResult = myRs.getString("native_name");
		String titleResult = myRs.getString("title");
		int yearMadeResult = myRs.getInt("year_made");
		String executionStatus = myRs.getString("execution_status");

		// movie_song SQL query
		sqlQuery = "select movie_id, song_id\n" + "FROM movie_song m\r\n" + "WHERE movie_id = '" + movieID + "'\n"
				+ "AND song_id = '" + songID + "'";

		// SQL query execution
		myRs = myStat.executeQuery(sqlQuery);

		// movie_song results
		myRs.next();
		int movieSongMovieID = myRs.getInt("movie_id");
		int movieSongSongID = myRs.getInt("song_id");

		// movies SQL query
		sqlQuery = "SELECT * FROM `movies` where native_name = '" + nativeName + "' AND year_made = " + yearMade;

		// SQL query execution
		ResultSet moviesResults = myStat.executeQuery(sqlQuery);
		
		//songs SQL query; check if title exists in songs table
		sqlQuery = "SELECT * FROM songs WHERE title = '" + titleResult + "'";
		
		//songs SQL query resultset
		ResultSet songsResults = myStat.executeQuery(sqlQuery);
		
		

		// TODO: Case 1: Aziz | Maamoun
		if ((nativeNameResult == null) && (String.valueOf(yearMadeResult) == null)) {

		}

		// TODO: Case 2: Aziz | Maamoun
		if (moviesResults.next()) {

			System.out.println("Error: Movie with native name " + nativeName + " and year " + yearMade
					+ " is a duplicate. Please try again");
		} else {

			// STEP 4: Extract Necessary Data
			System.out.println("Movie is not a duplicate......");
			System.out.println("Creating.....");
			createMovie(movieID, nativeName, englishName, yearMade);
		}
		// TODO: Case 3: Mahad
		//check if songsResults query is empty; title does not exist in songs table
		if (!songsResults.next()) {
			try {
				//create song in songs table
				System.out.println("Song does not exist in songs table");
				System.out.println("Creating new song entry");
				createSong(songID, titleResult);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// TODO: Case 4: Mahad
		//check if song exists in songs table
		if (songsResults.next())
			System.out.println("Song already exists in songs table. Create entry ignored");
		// Case 5: Max
		if ((String.valueOf(movieSongMovieID) != null) && (String.valueOf(movieSongSongID) != null)) {
			try {
				sqlQuery = "INSERT INTO movie_song VALUES (" + movieSongMovieID + "," + movieSongSongID + ")";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		// Case 6: Max
		// Implicit ignore in the if statement above.

		// TODO: Case 7: Group

		myConn.close();
		
		return true;
	}

}
