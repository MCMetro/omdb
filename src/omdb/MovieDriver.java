package omdb;
import java.sql.*;

public class MovieDriver {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {

            //Get Connection to the Database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");

            //Create a statment
            Statement myStat = myConn.createStatement();

            //Execute SQL Query
            ResultSet myRs = myStat.executeQuery("SELECT * FROM movies");


            //Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("movie_id") + ", " + myRs.getString("native_name") + ", " + myRs.getString("english_name"));
            }

            //Close the connection
            myConn.close();

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    
    // TODO: Add variables for driver calls later
    public void updateMovie() {
		String sqlUpdate = "UPDATE movies "
                + "SET english_name = ?, year_made = ? "
                + "WHERE movie_id = ?";

		//create connection to database
		//PreparedStatement allows for repeated use of mysql statement if needed. 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mydb", "root", "");
                PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

            // prepare data for update
            String movie_name = "test";
            int id = 3;
            int movie_year = 1933;
            pstmt.setString(1, movie_name);
            pstmt.setInt(2, movie_year);
            pstmt.setInt(3, id);
            
            
            //print out rows affected
            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    // TODO: Add variables for driver calls later
    public void createMovie() {
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
    
    // TODO: Add variables for driver calls later
    public void readMovie() {
    	
    }
    
    // TODO: Add variables for driver calls later
    public void deleteMovie() {
    	
    }

}
