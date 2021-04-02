package omdb;
//Tester Class for Theater.java

public class TheaterTester {
	
	public static void main(String[] args) {
		Theater t_1 = Theater.getInstance("Fargo");
		System.out.println(t_1.toString());
		Theater t_2 = Theater.getInstance("Lion King");
		System.out.println(t_2.toString());
		Theater t_3 = Theater.getInstance("My Cousin Vinny");
		System.out.println(t_3.toString());
	}
}