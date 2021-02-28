package omdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class readMovie {
	
public static void main(String[] args) {
		
		try {
			// Establishing connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb" , "root" , "");
			
			// statement creation
			Statement myStat = myConn.createStatement();
			
			// SQL query execution
			ResultSet myRs = myStat.executeQuery("select * from movies");
			ResultSet myRs = myStat.executeQuery( "select * from movie data");
			
			// process the results
			while(myRs.next()) {
				System.out.println(myRs.getString("movie_id") + ", " + myRs.getString("native_name") + ", " + myRs.getString("english_name") + ", " + myRs.getString("year_made"));
				System.out.println(myRs.getString("tag_line") + ", " + myRs.getString("movie_id") + ", " + myRs.getString("language") + ", " + myRs.getString("country")+ ", " + myRs.getString("genre")+ ", " + myRs.getString("plot"));
				
			}
			
			//close the connection
			myConn.close();
		}
		
		catch (Exception exc) {
			
			exc.printStackTrace();

}
