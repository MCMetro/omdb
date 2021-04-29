package omdb;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class OMDB {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		// Declare the movie variables
		int movieID;
		String englishName;
		String nativeName;
		int yearMade;
		String role;
		String stageName;
		String anagram;
		MovieDriver test = new MovieDriver();

		// Present the user with a menu
		System.out.println("Choose a Database Operation:");
		System.out.println("1. Create a new movie in the database.");
		System.out.println("2. Update a movie in the database.");
		System.out.println("3. Read a movie from the database.");
		System.out.println("4. Delete a movie from the database.");
		System.out.println("5. Run processMovieSong.");
		System.out.println("6. Run processMoviePeople.");
		System.out.println("7. Run processAnagrams.");
		System.out.println("8. Years count descending.");
		System.out.println("9. Find Movie based on Role and Stage Name.");
		System.out.println("10. Find Movies that have no songs.");
		System.out.println("11. Find Movies with no People.");
		System.out.println("12. Find Movies with Entered Anagram.");
		System.out.println("13. FullyDressedMovie.");
		System.out.println("q. Exit the program");
		System.out.print("\nEnter your choice: ");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();

		// Switch menu operations
		do {
			switch (choice) {
			// Create a new movie

			case "1":
				System.out.println("\nCreate a new movie! \n");
				System.out.print("Enter movie ID: ");
				movieID = scan.nextInt();
				System.out.print("Enter the movie's English Name: ");
				scan.nextLine(); // Consume the \n from nextInt above.
				englishName = scan.nextLine();
				System.out.print("Enter the movie's Native Name: ");
				nativeName = scan.nextLine();
				System.out.print("Enter the year the movie was made: ");
				yearMade = scan.nextInt();

				MovieDriver.createMovie(movieID, nativeName, englishName, yearMade);
				break;
			// Update an existing movie
			case "2":
				System.out.println("\nUpdate a movie! \n");
				System.out.print("Enter movie ID to be modified: ");
				movieID = scan.nextInt();
				System.out.print("Enter the new movie name: ");
				scan.nextLine(); // Consume the \n from nextInt above.
				englishName = scan.nextLine();
				System.out.print("Enter the new movie year: ");
				yearMade = scan.nextInt();
			
				MovieDriver.updateMovie(movieID, englishName, yearMade);
				break;
			// Read a movie
			case "3":
				System.out.println("\nRead a movie! \n");
				System.out.print("Enter movie ID: ");
				movieID = scan.nextInt();

				MovieDriver.readMovie(movieID);
				break;
			// Delete a movie from the database
			case "4":
				System.out.println("\nDelete a movie! \n");
				System.out.print("Enter movie ID: ");
				movieID = scan.nextInt();
				
				MovieDriver.deleteMovie(movieID);
			case "5":
				System.out.println("\nTesting processMovieSong\n");
				test.processMovieSong();
				break;
			case "6":
				System.out.println("Testing processMoviePeople\n");
				test.processMoviePeople();
			case "7":
				System.out.println("\nTesting processMovieAnagrams\n");
				test.processMovieAnagrams();
				break;
			case "8":
				System.out.println("\nTesting processYearsCount\n");
				test.processYearsCount();
				break;
			case "9":
				System.out.println("\nTesting processMovieSelection\n");
				System.out.print("Enter Role: ");
				role = scan.nextLine();
				System.out.print("Enter Actor/Actress Stage Name: ");
				stageName = scan.nextLine();
				test.processMovieSelection(role, stageName);
				break;
			case"10":
				System.out.println("\nTesting processMovieOnly\n");
				test.processMovieOnly();
			case"11":
				System.out.println("\nTesting processNoPeople\n");
				test.processNoPeople();
			case "12":
				System.out.println("\nTesting processAnagrams\n");
				System.out.print("Enter Anagram: ");
				anagram = scan.nextLine();
				test.processAnagrams(anagram);
				break;
			case "13":
				System.out.println("\nTesting FullyDressedMovie\n");
				System.out.print("Enter Movie ID: ");
				movieID = scan.nextInt();
				FullyDressedMovie fullyDressed = FullyDressedMovie.getInfo(movieID);
				Movie tm = fullyDressed.getMovie();
				System.out.println("Movie details \n");
				System.out.println("Movie ID: " + tm.getMovieID());
				System.out.println("Native Name: " + tm.getNativeName());
				System.out.println("Year Made: " + tm.getYearMade() + "\n");
				System.out.println("Songs in the movie: \n");
				if (fullyDressed.getSongList().isEmpty()) {
					System.out.println("List is Empty");
				} else {
					for (Song o : fullyDressed.getSongList()) {
						System.out.println(o.toString());
					}
				}
				System.out.println("\nPeople associated with each song in the movie: \n");
				if (fullyDressed.getSPList().isEmpty()) {
					System.out.println("List is Empty");
				} else {
					for (SongPeople sp : fullyDressed.getSPList()) {
						System.out.println(sp.toString());
					}
				}
				System.out.println("\nPeople associated with the movie: \n");
				if (fullyDressed.getMPList().isEmpty()) {
					System.out.println("List is Empty");
				} else {
					for (People p : fullyDressed.getMPList()) {
						System.out.println(p.toString());
					}
				}
				System.out.println("\nAnagrams of the Movie: \n");
				if (fullyDressed.getAList().isEmpty()) {
					System.out.println("List is Empty");
				} else {
					for (MovieAnagrams a : fullyDressed.getAList()) {
						System.out.println(a.toString());
					}
				}
			}
			choice = "q";
		} while (choice != "q");

		scan.close();
	}

}
