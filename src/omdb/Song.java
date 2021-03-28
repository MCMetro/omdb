package omdb;

public class Song {
	private int songID;
	private String lyrics;
	private String theme;
	private String title;
	
	public Song() {
		
	}
	
	public int getSongID() {
		return songID;
	}

	public String getLyrics() {
		return lyrics;
	}

	public String getTheme() {
		return theme;
	}

	public String getTitle() {
		return title;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
