package com.globant.academy.catalog;

import java.util.Scanner;

public class Admin extends User {
	Scanner s = new Scanner(System.in);

	public Admin() {
		super();
		name = "Sheldon";
		pass = "Bazinga";
	}

	private boolean addUser() {
		String usr, pss;
		System.out.print("\nUser: ");
		usr = s.next();
		System.out.print("\nPassword: ");
		pss = s.next();
		User user = new User(usr, pss);
		Login.addUser(user);
		return false;
	}

	private boolean deleteUser() {
		return false;
	}

	private boolean addComic() {
		return false;
	}

	private boolean modifyComic() {
		return false;
	}

	private boolean removeComic() {
		return false;
	}

	private boolean addGenre() {
		return false;
	}

	private boolean modifyGenre() {
		return false;
	}

	private boolean removeGenre() {
		return false;
	}
}
