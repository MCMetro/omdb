//package iteration;

import java.sql.*;
import java.util.Properties;

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

}
