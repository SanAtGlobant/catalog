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
				+ "\n5 - Delete comic" + "\n6 - View catalog" + "\n7 - Add genre" + "\n8 - Delete genre"
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
			addComic();
			break;
		case 5:
			removeComic();
			break;
		case 6:
			Shelf.displayComics();
			break;
		case 7:
			addGenre();
			break;
		case 8:
			removeGenre();
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
		System.out.print("\nUser: ");
		String usr = InputRead.getLine();
		System.out.print("\nPassword: ");
		String pss = InputRead.getLine();
		if (Login.addUser(new User(usr, pss))) {
			System.out.println("The user was deleted successfully.");
		} else {
			System.out.println("The provided user does not exist.");
		}
	}

	// ***** COMIC ADMIN METHODS
	private void addComic() {
		System.out.print("\nEnter the title: ");
		String title = InputRead.getLine();
		System.out.print("\nEnter the volume: ");
		int volume = InputRead.getInt();
		while (volume <= 0) {
			System.out.println("\nThe volume cannot be a negative number");
			volume = InputRead.getInt();
		}
		System.out.print("\nGenre: ");
		String genre = shelf.getGenre();
		shelf.addComic(new Comic(title, genre, volume));
		System.out.print("\n\nThe comic was added successfully.");
	}

	private void removeComic() {
		shelf.removeComic(shelf.getComic());
	}

	private void addGenre() {
		Genre genre = new Genre();
		System.out.println("Enter the new genre name: ");
		String g = InputRead.getLine();
		if (genre.addGenre(g)) {
			System.out.println("The genre " + g + " has been added.");
		} else {
			System.out.println("The genre " + " already exist.");
		}
	}

	private void removeGenre() {
		Genre genre = new Genre();
		System.out.println("Enter the genre to delete: ");
		String g = InputRead.getLine();
		if (genre.addGenre(g)) {
			System.out.println("The genre " + g + " has been deleted.");
		} else {
			System.out.println("The genre " + " does not exist.");
		}
	}
}
