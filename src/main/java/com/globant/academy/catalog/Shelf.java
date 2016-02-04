package com.globant.academy.catalog;

import java.util.TreeSet;

public class Shelf {
	private static TreeSet<Comic> comicList = new TreeSet<Comic>();

	public void addComic(Comic c) {
		if (comicList.add(c)) {
		} else {
			comicList.stream().filter(t -> t.equals(c)).forEach(comic -> comic.setCount(comic.getCount() + 1));
		}
	}

	public boolean removeComic(Comic c){
		return comicList.remove(c);
	}
	
	public String displayComics(){
		return comicList.toString();
	}
//	public boolean exist(Comic c) {
//		for (Comic o : comicList) {
//			if (o.getId().equals(c.getId())) {
//				return true;
//			}
//		}
//		return false;
//	}

}
