package omdb;

import java.io.File;
import java.util.Scanner;

public class MovieAnagrams {
	
	private int movieID;
	private String anagram;
	
	public MovieAnagrams(int movieID, String anagram) {
		this.movieID = movieID;
		this.anagram = anagram;
	}
	//movieID getter method
	public int getMovieID() {
		return movieID;
	}
	//anagram getter method 
	public String getAnagram() {
		return anagram;
	}
	
	public static void main(String[] args) throws Exception {
	
	    // pass the path to the file as a parameter
	    File file =
	      new File("");
	    Scanner sc = new Scanner(file);
	    
	    while (sc.hasNextLine()) {
	        System.out.println(sc.nextLine());
	    }
	    
	    sc.close();
	  }

}
