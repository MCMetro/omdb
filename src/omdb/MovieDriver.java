package omdb;
import java.sql.*;

public class MovieDriver {

	
// TODO: Add error handling to methods
// TODO: Change method types to boolean?
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
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
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
    	try {
			// Establishing connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");

			// statement creation
			Statement myStat = myConn.createStatement();

			// SQL query creation
			String sqlQuery = "select m.movie_id, m.english_name, m.native_name, m.year_made, md.tag_line, md.movie_id, md.language, md.country, md.genre, md.plot\r\n"
					+ "FROM movies m\r\n" + "LEFT JOIN movie_data md on m.movie_id = md.movie_id\r\n"
					+ "WHERE m.movie_id = '291'";

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
    
    // TODO: Add variables for driver calls later
    public void deleteMovie() {
        try {
            //STEP 1: Start Connection to the Database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
            System.out.println("Connected database successfully...");
            Statement stmt = null;
            //STEP 2: Execute a query
            System.out.println("Delete movie from movie database with ID?");
            stmt = conn.createStatement();
            //STEP 3: Delete Values
            String sql = "DELETE FROM movies WHERE movie_id = '1'";
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
