package omdb;

public class People {
	private int peopleID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String stageName;
	private String gender;
	private String imageName;

	public People() {
		
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
