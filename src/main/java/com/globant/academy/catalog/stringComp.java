package com.globant.academy.catalog;
import java.util.Comparator;

public class stringComp implements Comparator<User> {

	public int compare(User u1, User u2) {
		return u1.toString().compareTo(u2.toString());
	}
}