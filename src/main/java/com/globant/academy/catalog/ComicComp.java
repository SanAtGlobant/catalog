package com.globant.academy.catalog;
import java.util.Comparator;

public class ComicComp implements Comparator<Comic> {

	public int compare(Comic c1, Comic c2) {
		return c1.toString().toLowerCase().compareTo(c2.toString().toLowerCase());
	}
}