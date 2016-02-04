package com.globant.academy.catalog;

import java.util.Scanner;

public class MainMenu {

	Login login = new Login();
	protected byte option;
	private boolean exit;
	Scanner scan = new Scanner(System.in);
	static Admin admin = new Admin();

	public void runMenu() {

		while (!exit) {
			showMenu();
			option = askOption();
			processOption(option);
			while (login.getLoggedUser() != null) {
				switch (login.getLoggedUser().options()) {
				case 0:
					login.setLoggedUser(null);
					break;
				case -1:
					login.setLoggedUser(null);
					exit = true;
					break;
				}
			}
		}
		System.out.println("\nUntil next time! :)");
	}

	private void processOption(byte option) {
		switch (option) {
		case 1:
			String usr, pss;
			System.out.print("\nUser: ");
			usr = scan.next();
			System.out.print("\nPassword: ");
			pss = scan.next();
			User user = new User(usr, pss);
			login.logUser(user);
			break;
		case 2:
			Shelf.displayComics();
			break;
		case 3:
			System.out.println("Until next time! :)");
			exit = true;
			break;
		default:
			System.out.println("\nThe option is invalid, please choose again.\n");
			break;
		}
	}

	private byte askOption() {
		byte option = scan.nextByte();
		return option;
	}

	private void showMenu() {

		System.out.print("Welcome to the Comic Catalog!" + "\n\n1 - Login" + "\n2 - View catalog"
				+ "\n3 - Quit application" + "\n----------------------------------" + "\nOption: ");

	}
}
