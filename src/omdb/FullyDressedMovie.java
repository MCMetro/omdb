package omdb;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FullyDressedMovie {
	//FullyDressedMovie instance variables
	private Movie movieObj;
	private ArrayList<Song> songList = new ArrayList<Song>();
	private ArrayList<People> moviePeopleList = new ArrayList<People>();
	private ArrayList<SongPeople> songPeopleList = new ArrayList<SongPeople>();
	private ArrayList<MovieAnagrams> aList = new ArrayList<MovieAnagrams>();
	
	//Constructor Method
	public FullyDressedMovie() {
		
	}
	//toString method
	public String toString(FullyDressedMovie obj)  {
		return null;
	}
	//Getter Methods
	public Movie getMovie() {
		return this.movieObj;
	}
	public ArrayList<Song> getSongList() {
		return this.songList;
	}
	public ArrayList<People> getMPList() {
		return this.moviePeopleList;
	}
	public ArrayList<SongPeople> getSPList() {
		return this.songPeopleList;
	}
	public ArrayList<MovieAnagrams> getAList() {
		return this.aList;
	}
	//Setter methods
	public void setMovie(Movie movieObj) {
		this.movieObj = movieObj;
	}
	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}
	public void setMPList(ArrayList<People> mpList) {
		this.moviePeopleList = mpList;
	}
	public void setSPList(ArrayList<SongPeople> spList) {
		this.songPeopleList = spList;
	}
	public void setAList(ArrayList<MovieAnagrams> aList) {
		this.aList = aList;
	}
	public boolean isEmpty(Object o) {
		if(o == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static FullyDressedMovie getInfo(int movieID) {
		FullyDressedMovie myObj = new FullyDressedMovie();
		ArrayList<Song> slist = new ArrayList<Song>();
		ArrayList<People> mplist = new ArrayList<People>();
		ArrayList<SongPeople> splist = new ArrayList<SongPeople>();
		ArrayList<MovieAnagrams> alist = new ArrayList<MovieAnagrams>();
		try {
			// Establishing connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");

			// statement creation
			Statement myStat = myConn.createStatement();
			// SQL query creation
			// Extract movie details
			String sqlQuery = "select movie_id, english_name, native_name, year_made "
					+ "FROM movies "
					+ "WHERE movie_id = '" + movieID + "'";
			ResultSet myRs = myStat.executeQuery(sqlQuery);
			myRs.next();
			String nativeName = myRs.getString("native_name");
			String englishName = myRs.getString("english_name");
			int yearMade = myRs.getInt("year_made");
			Movie myMovie = new Movie(movieID, englishName, nativeName, yearMade);
			myObj.setMovie(myMovie);
			
			// READ EVERYTHING FROM SONGS ASSOCIATED TO MOVIE ID
			
			//sqlQuery to grab song IDs associated with movieID
			sqlQuery = "select ms.movie_ID, s.song_id, s.title FROM songs s LEFT JOIN movie_song ms "
					+ "ON s.song_id = ms.song_id \n" + 
					"WHERE ms.movie_id = " + movieID + ";";
			myRs = myStat.executeQuery(sqlQuery);
			// Extract song details for each song associated witht the movieID
			Statement myStat2 = myConn.createStatement();
			ResultSet myRs2;
			while(myRs.next()) {
				int songID = myRs.getInt("song_id");
				String title = myRs.getString("title");
				slist.add(new Song(songID, title));
				// READ EVERYTHING FROM PEOPLE FOR EACH SONG ASSOCIATED TO MOVIE ID
				sqlQuery = "SELECT sp.song_id, sp.people_id, sp.role, p.stage_name, \n" + 
						"p.first_name, p.last_name\n" + 
						"FROM song_people sp LEFT JOIN people p ON sp.people_id = p.people_id\n" + 
						"WHERE sp.song_id = " + songID;
				myRs2 = myStat2.executeQuery(sqlQuery);
				while (myRs2.next()) {
					int peopleID = myRs2.getInt("people_id");
					String stageName = myRs2.getString("stage_name");
					String role = myRs2.getString("role");
					String firstName = myRs2.getString("first_name");
					String lastName = myRs2.getString("last_name");
					splist.add(new SongPeople(songID, peopleID, role, stageName, firstName, lastName));
				}
				
			}
			// READ EVERYTHING FROM PEOPLE ASSOCIATED TO MOVIE ID
			sqlQuery = "select mp.movie_ID, p.people_id, mp.role, mp.screen_name, p.stage_name, p.first_name, p.last_name "
					+ "FROM people p LEFT JOIN movie_people mp "
					+ "ON p.people_id = mp.people_id \n" + 
					"WHERE mp.movie_id = " + movieID + ";";
			myRs = myStat.executeQuery(sqlQuery);
			while(myRs.next()) {
				int peopleID = myRs.getInt("people_id");
				String stageName = myRs.getString("stage_name");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				mplist.add(new People(peopleID, stageName, firstName, lastName));
			}
			
			
			// READ EVERYTHING FROM Anagrams ASSOCIATED TO MOVIE ID
			
			sqlQuery = "SELECT * FROM movie_anagrams "
					+ "WHERE movie_id = " + movieID;
			myRs = myStat.executeQuery(sqlQuery);
			while (myRs.next()) {
				String anagram = myRs.getString("anagram");
				alist.add(new MovieAnagrams(movieID, anagram));
			}
			myObj.setSongList(slist);
			myObj.setMPList(mplist);
			myObj.setSPList(splist);
			myObj.setAList(alist);

			// close the connection
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}	
		return myObj;
	}
	
	

	// TODO: Change to a boolean for true false and error handling.
	public static void main(String[] args) {
		FullyDressedMovie test = getInfo(291);
		Movie tm = test.getMovie();
		System.out.println("Movie details \n");
		System.out.println("Movie ID: " + tm.getMovieID());
		System.out.println("Native Name: " + tm.getNativeName());
		System.out.println("Year Made: " + tm.getYearMade() + "\n");
		System.out.println("Songs in the movie: \n");
		if (test.getSongList().isEmpty()) {
			System.out.println("List is Empty");
		} else {
			for (Song o : test.getSongList()) {
				System.out.println(o.toString());
			}
		}
		System.out.println("\nPeople associated with each song in the movie: \n");
		if (test.getSPList().isEmpty()) {
			System.out.println("List is Empty");
		} else {
			for (SongPeople sp : test.getSPList()) {
				System.out.println(sp.toString());
			}
		}
		System.out.println("\nPeople associated with the movie: \n");
		if (test.getMPList().isEmpty()) {
			System.out.println("List is Empty");
		} else {
			for (People p : test.getMPList()) {
				System.out.println(p.toString());
			}
		}
		System.out.println("\nAnagrams of the Movie: \n");
		if (test.getAList().isEmpty()) {
			System.out.println("List is Empty");
		} else {
			for (MovieAnagrams a : test.getAList()) {
				System.out.println(a.toString());
			}
		}
		
	}

}
