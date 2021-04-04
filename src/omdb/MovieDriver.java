package omdb;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDriver {
	
	private ArrayList<MovieSong> msList = new ArrayList<MovieSong>();
	private ArrayList<Song> songList = new ArrayList<Song>();
	private ArrayList<Movie> movieList = new ArrayList<Movie>();
	private ArrayList<People> peopleList = new ArrayList<People>();
	private ArrayList<MoviePeople> mpList = new ArrayList<MoviePeople>();
	private ArrayList<SongPeople> spList = new ArrayList<SongPeople>();
	
// TODO: Add error handling (change return types to boolean?) 
// TODO: Create a class object for each thing we touch such as movie, song, people

	
	public static void updateMovie(int movieID, String englishName, int yearMade) {
		String sqlUpdate = "UPDATE movies " + "SET english_name = ?, year_made = ? " + "WHERE movie_id = ?";
		
		// create connection to database
		// PreparedStatement allows for repeated use of mysql statement if needed.
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
				PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

			// prepare data for update
			pstmt.setString(1, englishName);
			pstmt.setInt(2, yearMade);
			pstmt.setInt(3, movieID);

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

	
	public boolean processMovieSong() throws SQLException {
		
		//create variables for movieID, songID and englishName
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
			//updated columns for mspr_test_data
			String stageName = myTestData.getString("stage_name");
			String role = myTestData.getString("role");
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
					movieList.add(new Movie(movieID, englishName, nativeName, yearMade));
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
				temp = Song.addApostrophe(title, position);
				title = temp;
			}
			
			//check if songsResults query is empty; title does not exist in songs table
			
			if (!Song.checkSong(title)) {
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
					songList.add(new Song(songID, title));
					//song created, add execution status to string array
					myArray[1] = "S Created";
	
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			//title exists in song table, ignore entry
			} else {
				try {
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
					msList.add(new MovieSong(movieID, songID));
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
	
	//Process mpr_test_data table
	public boolean processMoviePeople() throws SQLException {
		
		//create variables for movieID, songID and englishName
		int movieID = 0;
		int peopleID = 0;
		String englishName = "";
		
		// Establishing connection to database
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");

		// statement creation
		Statement myStat = myConn.createStatement();

		// SQL query creation
		String sqlQuery = "select * \n" + "FROM mpr_test_data m\r\n";

		// SQL query execution
		ResultSet myTestData = myStat.executeQuery(sqlQuery);

		//loop through ms_test_data, gather values per row
		while(myTestData.next()) {

			int mprID = myTestData.getInt("id");
			String stageName = myTestData.getString("stage_name");
			String nativeName = myTestData.getString("native_name");
			int yearMade = myTestData.getInt("year_made");
			String role = myTestData.getString("role");
			String screenName = myTestData.getString("screen_name");
			//string array to hold value of execution status by case
			String[] myArray = new String[3]; 
			ResultSet myRs;
		
	
			// TODO: Case 1: Aziz | Maamoun
			//check if movie does not exist and create if needed
			
			//get index of single quote from nativeName
			int position = nativeName.indexOf('\'');
			//check if title has single quote in it
			if (position >= 0) {
				//if title has apostrophe, add addition single quote at index
				String temp;
				temp = Song.addApostrophe(nativeName, position);
				nativeName = temp;
			}
			position = screenName.indexOf('\'');
			if (position >= 0) {
				//if title has apostrophe, add addition single quote at index
				String temp;
				temp = Song.addApostrophe(screenName, position);
				screenName = temp;
			}
			
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
					movieList.add(new Movie(movieID, englishName, nativeName, yearMade));
					//movie created, add execution status to string array
					myArray[0] = "M Created";
	
				}
				// STEP 6: Catch Errors
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			// TODO: Case 3: Mahad
			
			
			//check if person with stageName exists in people table
			//create people entry if person does not exist else ignore
			
			if (!People.checkPeople(stageName)) {
				try {
					//create people in songs table
					Statement stmt = myConn.createStatement();
					
					//people SQL query for last row
					String myQuery = "SELECT * FROM people WHERE people_id = (SELECT max(people_id) FROM people)";
					
					//get query results
					ResultSet Rs = stmt.executeQuery(myQuery);
					Rs.next();
					//get value of last people_id in people table
					int maxPeopleId = Rs.getInt("people_id");
					//increment value by 1
					int currentPeopleID = maxPeopleId + 1;
					//update people_id value
					peopleID = currentPeopleID;
					//create new people at last row
					peopleList.add(new People(peopleID, stageName));
					//people created, add execution status to string array
					myArray[1] = "P Created";
	
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			//stageName exists in people table, ignore entry
			} else {
				try {
					Statement stmt = myConn.createStatement();
					String myQuery = "SELECT * FROM people WHERE stage_name = '" + stageName + "'";
					ResultSet Rs = stmt.executeQuery(myQuery);
					Rs.next();
					int realPeopleId = Rs.getInt("people_id");
					peopleID = realPeopleId;
					myArray[1] = "P Ignored";
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
			
			// Case 5: Max
			//movie_people SQL query
			sqlQuery = "select *\n" + "FROM movie_people m\r\n" + "WHERE movie_id = " + movieID + "\n"
					+ "AND people_id = " + peopleID + " AND role = '" + role + "' AND screen_name = "
							+ "'" + screenName + "';";

			// SQL query execution
			Statement mpStat = myConn.createStatement();
			myRs = mpStat.executeQuery(sqlQuery);
	
			//movie_people does not exist; create movie_people entry
			if (!myRs.next()) {
				try {
					mpList.add(new MoviePeople(movieID, peopleID, role, screenName));
					//movie_people created, add execution status to string array
					myArray[2] = "R Created";
				} catch (Exception e) {
					e.printStackTrace();
				}
			//movie_people exists; ignore entry
			} else {
				//movie people not created, add execution status to string array
				myArray[2] = "R Ignored";
			}
	
			// TODO: Case 7: Group
			//Update the Execution Status
			//Create string based on which cases were implemented
			String myExecutionStatus = myArray[0] + ", " + myArray[1] + ", " + myArray[2];
			//update execution status on current row with string
			String sqlUpdate = "UPDATE mpr_test_data " + 
					"SET execution_status = '" + myExecutionStatus + "' WHERE id = " + mprID + ";";
			Statement esStat = myConn.createStatement();
			esStat.executeUpdate(sqlUpdate);
		}
		//close connection to database
		myConn.close();
		System.out.println("processMoviePeople Complete!");
		return true;
	}
	
	

}
