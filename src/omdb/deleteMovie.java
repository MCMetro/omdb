package omdb;
{
	//package iteration;
	import java.sql.*;
	public class MovieDriver {
	    public static void main(String[] args) {
	        //Delete  Movie
	        try {
	            //STEP 1: Start Connection to the Database
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
	            System.out.println("Connected database successfully...");
	            Statement stmt = null;
	            //STEP 2: Execute a query
	            System.out.println("Delete movie from movie database with ID?");
	            stmt = conn.createStatement();
	            //STEP 3: Insert Values
	            String sql = "DELETE * FROM  movies " +
	            		"WHERE id = 1";
	            stmt.executeUpdate(sql);
	            System.out.println("Movie deleted successfully!");
	            //STEP 4: Close the connection
	            conn.close();
	            System.out.println("Goodbye!");
	            //STEP 5: Catch Errors
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}
