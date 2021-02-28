//CRUD operation for UPDATE Movie file
package omdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateMovie {
	
	public static void main(String[] args) {
		
		String sqlUpdate = "UPDATE movies "
                + "SET english_name = ?, year_made = ? "
                + "WHERE movie_id = ?";

		//create connection to database
		//PreparedStatement allows for repeated use of mysql statement if needed. 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
                PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

            // prepare data for update
            String movie_name = "test";
            int id = 1;
            int movie_year = 2021;
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
        //jdbc update code source: https://www.mysqltutorial.org/mysql-jdbc-update/
	}
}
