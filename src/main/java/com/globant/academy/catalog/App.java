package com.globant.academy.catalog;

public class App {

	static MainMenu mainMenu = new MainMenu();
	static Admin admin = new Admin();

	public static void main(String[] args) {

		mainMenu.runMenu();
		// System.out.println(admin.toString());

		// System.out.println(Login.loggedUser);

	}
}
