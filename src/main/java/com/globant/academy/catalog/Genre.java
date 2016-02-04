package com.globant.academy.catalog;

import java.util.TreeSet;

public class Genre {
	
	private static TreeSet<String> genreList = new TreeSet<String>();
	
	public boolean addGenre(String s){
		return genreList.add(s);
	}
	
	public boolean removeGenre(String s){
		return genreList.remove(s);
	}
	
	public String displayGenres(){
		return genreList.toString();
	}

}
