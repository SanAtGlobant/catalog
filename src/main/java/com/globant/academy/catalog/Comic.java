package com.globant.academy.catalog;

public class Comic {
	private String title;
	private String genre;
	private int count = 1;
	private int borrowed = 0;
	private int volume;

	public int getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(int borrowed) {
		this.borrowed = borrowed;
	}

	@Override
	public boolean equals(Object obj) {
		if (getGenre().equals(((Comic) obj).getGenre()) && getTitle().equals(((Comic) obj).getTitle())
				&& getVolume() == ((Comic) obj).getVolume()) {
			return true;
		}
		return false;
	}

	// ***** GETTERS & SETTERS

	@Override
	public String toString() {
		return genre + "    " + title + "    " + volume;
	}

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

	public String getId() {
		return getGenre() + getTitle() + getVolume();
	}

	// ***** CONSTRUCTOR *****
	public Comic(String title, String genre, int volume) {
		this.title = title;
		this.genre = genre;
		this.volume = volume;
	}

}
