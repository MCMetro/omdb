package omdb;

import java.sql.*;
import java.util.Scanner;

public class checkcreateMovie {

	// TODO: Change to a boolean for true false and error handling.
	public static void main(String[] args) {
		// Look for Movie
		int movieID;
		String englishName;
		String nativeName;
		int yearMade;
		Scanner scan = new Scanner(System.in);
		try {

			// STEP 0: Ask for movie details
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

			// Print Test:

			// System.out.println(movieID);
			// System.out.println(englishName);
			// System.out.println(nativeName);
			// System.out.println(yearMade);

			// STEP 1: Start Connection to the Database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			System.out.println("Connected to database successfully...");
			Statement stmt = null;
			// STEP 2: Execute a query
			System.out.println("Rnning sql query...");
			stmt = conn.createStatement();
			// STEP 3: Insert Values
			String sqlQuery = "SELECT * FROM `movies` where native_name = '" + nativeName + "' AND year_made = " + yearMade;;
			ResultSet myRs = stmt.executeQuery(sqlQuery);

			if (myRs.next()) {

				System.out.println("Error: Movie with native name " + nativeName + " and year " + yearMade + " is a duplicate. Please try again");
			} else {

				// STEP 4: Extract Necessary Data
				System.out.println("Movie is not a duplicate......");
				System.out.println("Creating.....");
				MovieDriver.createMovie(movieID, nativeName, englishName, yearMade);

			}

			// STEP 6: Close the connection
		conn.close();
			scan.close();
			// STEP 7: Catch Errors
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}