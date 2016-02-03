package com.globant.academy.catalog;
import java.util.Scanner;

public class MainMenu {

	static Login login = new Login();
	protected byte option;
	private boolean exit;
	// private boolean userExit;
	Scanner scan = new Scanner(System.in);

	public void runMenu() {

		while (!exit) {
			showMenu();
			option = askOption();
			processOption(option);
			while (login.loggedUser != null) {
				showUserMenu(login.loggedUser);
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

	private String askString() {
		String s = null;
		s = scan.nextLine();
		return s;
	}

	private byte askOption() {
		byte option = scan.nextByte();
		return option;
	}

	private void showMenu() {

		System.out.print("Welcome to the Comic Catalog!" + "\n\n1 - Login" + "\n2 - Show catalog"
				+ "\n3 - Quit application" + "\n----------------------------------" + "\nOption: ");

	}

	private void showUserMenu(User currentUser) {
		switch (currentUser.getClass().toString().substring(6)) {
		case "Admin":
			System.out.print("\n\n1 - Add user" + "\n2 - Delete user" + "\n3 - Add comic" + "\n4 - Modify comic"
					+ "\n5 - Delete comic" + "\n6 - Add genre" + "\n7 - Modify genre" + "\n8 - Delete genre"+ "\n9 - Log out"+ "\n0 - Quit application"
					+ "\n----------------------------------" + "\nOption: ");
			break;
		case "User":
			System.out.print("Welcome to the Comic Catalog!" + "\n\n1 - Login" + "\n2 - Show catalog"
					+ "\n3 - Quit application" + "\n----------------------------------" + "\nOption: ");
			break;
		}
	}
}
