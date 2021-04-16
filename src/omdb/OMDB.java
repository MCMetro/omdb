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
		MovieDriver test = new MovieDriver();

		// Present the user with a menu
		System.out.println("Choose a Database Operation:");
		System.out.println("1. Create a new movie in the database.");
		System.out.println("2. Update a movie in the database.");
		System.out.println("3. Read a movie from the database.");
		System.out.println("4. Delete a movie from the database.");
		System.out.println("5. Run processMovieSong.");
		System.out.println("6. Run processMoviePeople.");
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
			}
			choice = "q";
		} while (choice != "q");

		scan.close();
	}

}
