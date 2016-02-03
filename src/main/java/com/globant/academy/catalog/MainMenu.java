package com.globant.academy.catalog;

import java.util.Scanner;

public class MainMenu {

	static Login login = new Login();
	protected byte option;
	private boolean exit;
	Scanner scan = new Scanner(System.in);

	public void runMenu() {

		while (!exit) {
			showMenu();
			option = askOption();
			processOption(option);
			while (Login.getLoggedUser() != null) {
				showUserMenu();
				byte userOption = askOption();
				processUserOption(userOption);
			}
		}
	}

	private void processUserOption(byte userOption) {
		// TODO Auto-generated method stub

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
			break;
		case 3:
			System.out.println("Until next time! :)");
			exit = false;
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

	private void showUserMenu() {
		switch (Login.getLoggedUserPrivilege()) {
		case "Admin":
			System.out.print("\n\n1 - Add user" + "\n2 - Delete user" + "\n3 - Add comic" + "\n4 - Modify comic"
					+ "\n5 - Delete comic" + "\n6 - Add genre" + "\n7 - Modify genre" + "\n8 - Delete genre"
					+ "\n9 - Log out" + "\n0 - Quit application" + "\n----------------------------------"
					+ "\nOption: ");
			break;
		case "User":
			System.out.print("\n\n1 - Borrow comic" + "\n2 - Return comic" + "\n3 - View catalog" + "\n4 - Log out"
					+ "\n0 - Quit application" + "\n----------------------------------"
					+ "\nOption: ");
			break;
		}
	}
}
