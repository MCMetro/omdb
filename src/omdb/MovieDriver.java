package omdb;

import java.sql.*;
import java.util.Scanner;

public class MovieDriver {

// TODO: Add error handling (change return types to boolean?) 
// TODO: Create a class object for each thing we touch such as movie, song, people

//	public static void updateMovie(int movieID, String englishName, int yearMade) {
//		String sqlUpdate = "UPDATE movies " + "SET english_name = ?, year_made = ? " + "WHERE movie_id = ?";
//		
//		// Set local variables to user input data.
//		int id = movieID;
//		String movie_name = englishName;
//		int movie_year = yearMade;
//		// create connection to database
//		// PreparedStatement allows for repeated use of mysql statement if needed.
//		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
//				PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
//
//			// prepare data for update
//			pstmt.setString(1, movie_name);
//			pstmt.setInt(2, movie_year);
//			pstmt.setInt(3, id);
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
	

	public static void createMovie(int movieID, String englishName, String nativeName, int year) {
		try {
			// STEP 1: Start Connection to the Database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			System.out.println("Connected database successfully...");
			Statement stmt = null;
			// STEP 2: Execute a query
			//System.out.println("Inserting new movie into the movie omdb.movies...");
			stmt = conn.createStatement();
			// STEP 3: Insert Values
			String sql = "INSERT INTO movies " + "VALUES (" + movieID + ", '" + englishName + "', '" + nativeName
					+ "', " + year + ")";
			stmt.executeUpdate(sql);
			//System.out.println("Movie created successfully!");
			// STEP 4: Close the connection
			conn.close();
			//System.out.println("Goodbye!");
			// STEP 5: Catch Errors
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void createSong(int songID, String title) { 
		//set null and "N/A" values for lyrics and themes respectively
		String lyrics = null;
		String theme = "N/A";
		try {	
			//establish connection with database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			Statement mystmt = null;
			mystmt = conn.createStatement();
			//create insert statement
			String mySql = "INSERT INTO songs " + "VALUES (" + songID + ", '" + title + "', '" + lyrics + "', '" + theme + "')";
			
			//execute query
			mystmt.executeUpdate(mySql);
			//System.out.println("Added song into songs table!");
			//close connection
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//boolean method which checks if song with title 'title' exists in songs table
	//returns true if song exists, false if song does not exist
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
			}
			//check if song exists in songs table
			if (songsResults.next()) {
				b = true;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
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
	
	//method to duplicate apostrophe in title
	public static String addApostrophe(String title, int position) {
		//apostrophe char
		char ch = '\'';
		int len = title.length();
		//create chararray with title length + 1;
	    char[] charArray = new char[len + 1];
	    //copy string values upto index of single quote into the charArray
	    title.getChars(0, position, charArray, 0);
	    //add addition single quote after first single quote
	    charArray[position] = ch;
	    //copy rest of string values into the charArray
	    title.getChars(position, len, charArray, position + 1); 
	    //return string value of the charArray
	    return new String(charArray);
	    //code details found at https://www.baeldung.com/java-add-character-to-string
	}
	
	public static boolean processMovieSong() throws SQLException {
		
		//create varaibles for movieID, songID and englishName
		int movieID = 0;
		int songID = 0;
		String englishName = "";
		
		// Establishing connection to database
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");

		// statement creation
		Statement myStat = myConn.createStatement();

		// SQL query creation
		String sqlQuery = "select * \n" + "FROM ms_test_data m\r\n";

		// SQL query execution
		ResultSet myTestData = myStat.executeQuery(sqlQuery);

		//loop through ms_test_data, gather values per row
		while(myTestData.next()) {

			String title = myTestData.getString("title");
			String nativeName = myTestData.getString("native_name");
			int yearMade = myTestData.getInt("year_made");
			//string array to hold value of execution status by case
			String[] myArray = new String[3]; 
			ResultSet myRs;
		
	
			// TODO: Case 1: Aziz | Maamoun
			//check if movie does not exist and create if needed
			try {
				String mysqlQuery = "SELECT * FROM `movies` where native_name = '" + nativeName + "' AND year_made = " + yearMade;;
				Statement movieStat = myConn.createStatement();
				ResultSet myResults = movieStat.executeQuery(mysqlQuery);

				if (myResults.next()) {
					//movie creation ignored, add execution status to string array
					myArray[0] = "M Ignored";
					//movie already exists, grab value of movieID from table and update variable
					int realMovieID = myResults.getInt("movie_id");
					movieID = realMovieID;
					
					
					//Case 2: 
				} else {
					//Query to find last movie_id value in movie table
					String maxMovieIDQ = "SELECT * FROM movies WHERE movie_id = (SELECT max(movie_id) FROM movies)";
					Statement movieMax = myConn.createStatement();
					ResultSet maxMovieResult = movieMax.executeQuery(maxMovieIDQ);
					maxMovieResult.next();
					int maxMovieID = maxMovieResult.getInt("movie_id");
					//increment maxMovieID by 1
					int currentMovieID = maxMovieID + 1;
					//set values of movieID and englishName
					movieID = currentMovieID;
					englishName = nativeName;
					//createMovie entry at end of the table
					createMovie(movieID, englishName, nativeName, yearMade);
					//movie created, add execution status to string array
					myArray[0] = "M Created";
	
				}
				// STEP 6: Catch Errors
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			// TODO: Case 3: Mahad
			//get index of single quote from title
			int position = title.indexOf('\'');
			//check if title has single quote in it
			if (position >= 0) {
				//if title has apostrophe, add addition single quote at index
				String temp;
				temp = addApostrophe(title, position);
				title = temp;
			}
			//check if songsResults query is empty; title does not exist in songs table
			if (!checkSong(title)) {
				try {
					//create song in songs table
					Statement stmt = myConn.createStatement();
					
					//songs SQL query for last row
					String myQuery = "SELECT * FROM songs WHERE song_id = (SELECT max(song_id) FROM songs)";
					
					//get query results
					ResultSet Rs = stmt.executeQuery(myQuery);
					Rs.next();
					//get value of last song_id in songs table
					int maxSongId = Rs.getInt("song_id");
					//increment value by 1
					int currentSongID = maxSongId + 1;
					//update song_id value
					songID = currentSongID;
					//createSong at end of songs table
					createSong(songID, title);
					//song created, add execution status to string array
					myArray[1] = "S Created";
	
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			// TODO: Case 4: Mahad
			//check if song exists in songs table
			if (checkSong(title)) {
				try {
					//System.out.println("Song already exists in songs table. Create entry ignored");
					Statement stmt = myConn.createStatement();
					String myQuery = "SELECT * FROM songs WHERE title = '" + title + "'";
					ResultSet Rs = stmt.executeQuery(myQuery);
					Rs.next();
					int realSongId = Rs.getInt("song_id");
					songID = realSongId;
					myArray[1] = "S Ignored";
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
			
			// Case 5: Max
			//movie_song SQL query
			sqlQuery = "select movie_id, song_id\n" + "FROM movie_song m\r\n" + "WHERE movie_id = " + movieID + "\n"
					+ "AND song_id = " + songID + ";";

			// SQL query execution
			Statement msStat = myConn.createStatement();
			myRs = msStat.executeQuery(sqlQuery);
	
			//movie_song does not exist; create movie_song entry
			if (!myRs.next()) {
				try {
					sqlQuery = "INSERT INTO movie_song VALUES (" + movieID + ", " + songID + ")";
					Statement msStat2 = myConn.createStatement();
					msStat2.executeUpdate(sqlQuery);
					//movie_song created, add execution status to string array
					myArray[2] = "MS Created";
				} catch (Exception e) {
					e.printStackTrace();
				}
			//movie_song exists; ignore entry
			} else {
				//movie song not created, add execution status to string array
				myArray[2] = "MS Ignored";
			}
			// Case 6: Max
			// Implicit ignore in the if statement above.
	
			// TODO: Case 7: Group
			//Update the Execution Status
			//Create string based on which cases were implemented
			String myExecutionStatus = myArray[0] + ", " + myArray[1] + ", " + myArray[2];
			//update execution status on current row with string
			String sqlUpdate = "UPDATE ms_test_data " + 
					"SET execution_status = '" + myExecutionStatus + "' WHERE native_name = '" +
					nativeName + "' AND title = '" + title + "'";
			Statement esStat = myConn.createStatement();
			esStat.executeUpdate(sqlUpdate);
		}
		//close connection to database
		myConn.close();
		System.out.println("processMovieSong Complete!");
		return true;
	}

}
