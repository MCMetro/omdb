package omdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//test
public class People {
	private int peopleID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String stageName;
	private String gender;
	private String imageName;

	public People(int peopleID, String stageName) {
		this.peopleID = peopleID;
		this.stageName = stageName;

	}
	
	public static boolean checkPeople(String stageName) {
		boolean b = false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");
			Statement myStat = conn.createStatement();
			
			//people SQL query; check if stage_name exists in people table
			String sqlQuery = "SELECT * FROM people WHERE stage_name = '" + stageName + "'";
			
			//people SQL query resultset
			ResultSet peopleResults = myStat.executeQuery(sqlQuery);
			
			//check if peopleResults query is empty; stage does not exist in people table
			if (!peopleResults.next()) {
				b = false;
			} else {
				b = true;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public int getPeopleID() {
		return peopleID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStageName() {
		return stageName;
	}

	public String getGender() {
		return gender;
	}

	public String getImageName() {
		return imageName;
	}

	public void setPeopleID(int peopleID) {
		this.peopleID = peopleID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
