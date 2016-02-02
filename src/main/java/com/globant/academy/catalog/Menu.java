package com.globant.academy.catalog;

public class Menu {

	public void clearConsole() {
		for (int i = 0; i < 200; i++) {
			System.out.print("\b");
		}
	}

	public void initial() {
		System.out.println("Welcome to the Comic Catalog.");
		System.out.println("");
		System.out.println("Options: ");
		System.out.println("1- Login");
		System.out.println("2- Guest Access");
		System.out.println("3- Exit");
	}

	public void guestAccess() {
		clearConsole();
		System.out.println("Welcome to the Comic Catalog.");
		System.out.println("");
		System.out.println("Options: ");
		System.out.println("1- Display Comics");
		System.out.println("2- Back");
	}
}
