package omdb;

import java.sql.*;
import java.util.Scanner;

public class FullyDressedMovie {

	// TODO: Change to a boolean for true false and error handling.
	public static void main(String[] args) {
		int movieID;
		Scanner scan = new Scanner(System.in);
		
		
		
		scan.nextLine(); // Consume the \n from nextInt above.

		try {
			// Establishing connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");

			// statement creation
			Statement myStat = myConn.createStatement();
			System.out.print("Enter the movie's ID: ");
			movieID = scan.nextInt();
						
			// SQL query creation
			String sqlQuery = "select m.movie_id, m.english_name, m.native_name, m.year_made, md.tag_line, md.movie_id, md.language, md.country, md.genre, md.plot, ma.anagram\r\n"
				+ "FROM movies m\r\n" 
				+ "LEFT JOIN movie_data md on m.movie_id = md.movie_id\r\n"
				+ "LEFT JOIN movie_anagrams ma on m.movie_id = ma.movie_id\r\n"
				+ "WHERE m.movie_id = '" + movieID + "'";
			
			// READ EVERYTHING FROM SONGS ASSOCIATED TO MOVIE ID
			// READ EVERYTHING FROM PEOPLE FOR EACH SONG ASSOCIATED TO MOVIE ID
			String sqlSongs = "select s.song_id, s.title, s.theme, s.lyrics, sp.role, p.first_name, p.last_name, p.middle_name, p.stage_name\r\n"
				+ "FROM movies m\r\n"
				+ "LEFT JOIN movie_song ms on m.movie_id = ms.movie_id\r\n"
				+ "LEFT JOIN songs s on ms.song_id = s.song_id\r\n"
				+ "LEFT JOIN song_people sp on s.song_id = sp.song_id\r\n"
				+ "LEFT JOIN people p on sp.people_id = p.people_id\r\n"
				+ "WHERE m.movie_id = '" + movieID + "'";

			// READ EVERYTHING FROM PEOPLE ASSOCIATED TO MOVIE ID
			String sqlMoviePeople = "select p.people_id, p.first_name, p.middle_name, p.last_name, p.stage_name, mp.role, mp.screen_name\r\n"
				+ "FROM movies m\r\n"
				+ "LEFT JOIN movie_people mp on m.movie_id = mp.movie_id\r\n"
				+ "LEFT JOIN people p on mp.people_id = p.people_id\r\n"
				+ "WHERE m.movie_id = '" + movieID + "'";
			// READ EVERYTHING FROM Anagrams ASSOCIATED TO MOVIE ID
			String sqlAnagrams = ""

			// SQL query execution
			ResultSet myRs = myStat.executeQuery(sqlQuery);
			ResultSet songRs = myStat.executeQuery(sqlSongs);
			ResultSet peopleRs = myStat.executeQuery(sqlMoviePeople);
			ResultSet anagramRs = myStat.executeQuery(sqlAnagrams);

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
			String anagram = myRs.getString("anagram");
			// process the results
			System.out.println("Movie ID: " + movieId);
			System.out.println("English Name: " + englishName);
			System.out.println("Native Name: " + nativeName);
			System.out.println("Year Made: " + yearMade);
			System.out.println("Country: " + country);
			System.out.println("Genre: " + genre);
			System.out.println("Plot: " + plot);
			System.out.println("Tagline: " + tagLine);

			songRs.next();
			while(songRs.hasNextLine()){
				int songId = songRs.getInt("song_id");
				String songTitle = songRs.getString("title");
				String theme = songRs.getString("theme");
				String lyrics = songRs.getString("lyrics");
				String songRole = songRs.getString("role");
				String firstName = songRs.getString("first_name");
				String lastName = songRs.getString("last_name");
				String middleName = songRs.getString("middle_name");
				String stageName = songRs.getString("stage_name");

				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
			}

			sqlMovieRs.next();




			// close the connection
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
