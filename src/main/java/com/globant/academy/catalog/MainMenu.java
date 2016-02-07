package com.globant.academy.catalog;

public class MainMenu {

	private Login login = new Login();
	private byte option;
	private boolean exit;

	public void runMenu() {

		while (!exit) {
			showMenu();
			option = InputRead.getByte();
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
			usr = InputRead.getLine();
			System.out.print("\nPassword: ");
			pss = InputRead.getLine();
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

	private void showMenu() {
		System.out.print("Welcome to the Comic Catalog!" + "\n\n1 - Login" + "\n2 - View catalog"
				+ "\n3 - Quit application" + "\n----------------------------------" + "\nOption: ");
	}
}
