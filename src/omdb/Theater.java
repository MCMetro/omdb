package omdb;

//Singleton Design Pattern Implementation
//Group: Bears

public class Theater {
	private static Theater instance;
	public String name;
	
	private Theater(String name) {
		this.name = name;
	}
	
	public static Theater getInstance(String name) {
		if (instance == null) {
			instance = new Theater(name);
		}
		return instance;
	}
	
	public String toString() {
		return name;
	}
}