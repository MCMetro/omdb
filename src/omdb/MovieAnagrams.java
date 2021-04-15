package omdb;


public class MovieAnagrams {
	
	private int movieID;
	private String anagrams;
	
	public MovieAnagrams(int movieID, String anagrams) {
		this.movieID = movieID;
		this.anagrams = anagrams;
	}
	//movieID getter method
	public int getMovieID() {
		return movieID;
	}
	//anagram getter method 
	public String getAnagram() {
		return anagrams;
	}


}
