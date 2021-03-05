package omdb;

import java.sql.*;
public class createMovie {
	
	// TODO: Change to a boolean for true false and error handling.
  public static void main(String[] args) {
      //Create Movie
      try {
          //STEP 1: Start Connection to the Database
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
          System.out.println("Connected database successfully...");
          Statement stmt = null;
          //STEP 2: Execute a query
          System.out.println("Inserting new movie into the movie omdb.movies...");
          stmt = conn.createStatement();
          //STEP 3: Insert Values
          String sql = "INSERT INTO movies " +
                  "VALUES (1, 'Tenet', 'Tenet', 2020)";
          stmt.executeUpdate(sql);
          System.out.println("Movie created successfully!");
          //STEP 4: Close the connection
          conn.close();
          System.out.println("Goodbye!");
          //STEP 5: Catch Errors
      } catch (Exception ex) {
          ex.printStackTrace();
      }
  }
}