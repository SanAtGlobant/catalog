package com.globant.academy.catalog;

public class Comic {
	private String title;
	private String genre;
	private int count = 0;
	private int volume;

	
	
	

	// ***** GETTERS & SETTERS
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public String getId(){
		return getGenre()+getTitle()+getVolume();
	}
	// ***** CONSTRUCTOR *****
	public Comic(String title, String genre, int volume) {
		this.title = title;
		this.genre = genre;
		this.volume = volume;
	}

}
