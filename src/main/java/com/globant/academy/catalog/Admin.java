package com.globant.academy.catalog;

public class Admin extends User {

	public Admin() {
		super();
		name = "Sheldon";
		pass = "Bazinga";
	}

	// ***** MENU METHODS *****

	public byte options() {

		System.out.print("\n\n1 - Add user" + "\n2 - Delete user" + "\n3 - Display users" + "\n4 - Add comic"
				+ "\n5 - Delete comic" + "\n6 - Add genre" + "\n7 - Modify genre" + "\n8 - Delete genre"
				+ "\n9 - Log out" + "\n0 - Quit application" + "\n----------------------------------" + "\nOption: ");

		byte selection = InputRead.getByte();
		switch (selection) {
		case 1:
			addUser();
			break;
		case 2:
			deleteUser();
			break;
		case 3:
			Login.displayUsers();
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			return 0;
		case 0:
			return -1;
		default:
			break;
		}
		return 1;
	}

	// ***** USER ADMIN METHODS
	public void addUser() {
		String usr, pss;
		System.out.print("\nUser: ");
		usr = InputRead.getLine();
		System.out.print("\nPassword: ");
		pss = InputRead.getLine();
		User user = new User(usr, pss);
		if (Login.addUser(user)) {
			System.out.println("The user was added successfully.");
		} else {
			System.out.println("The user was already created.");
		}
	}

	public void deleteUser() {
		String usr, pss;
		System.out.print("\nUser: ");
		usr = InputRead.getLine();
		System.out.print("\nPassword: ");
		pss = InputRead.getLine();
		User user = new User(usr, pss);
		if (Login.addUser(user)) {
			System.out.println("The user was deleted successfully.");
		} else {
			System.out.println("The provided user does not exist.");
		}
	}

	// ***** COMIC ADMIN METHODS
	private void addComic() {
		Shelf shelf = new Shelf();
		String title;
		byte volume;
		System.out.print("\nUser: ");
		usr = InputRead.getLine();
		System.out.print("\nPassword: ");
		pss = InputRead.getLine();
		User user = new User(usr, pss);
	}

	private boolean modifyComic() {
		return false;
	}

	private boolean removeComic() {
		return false;
	}

	private void addGenre() {
		
		Genre genre = new Genre();
		System.out.println("Enter the new genre name: ");
		String g = InputRead.getLine();
		genre.addGenre(g);
	}

	private boolean modifyGenre() {
		return false;
	}

	private boolean removeGenre() {
		Genre genre = new Genre();
		String g = InputRead.getLine();
		genre.addGenre(g);
		return false;
	}
}
