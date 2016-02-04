package com.globant.academy.catalog;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
			addComic();
			break;
		case 5:
			break;
		case 6:
			addGenre();
			break;
		case 7:
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
		String title, genre;
		int volume;
		System.out.print("\nEnter the title: ");
		title = InputRead.getLine();
		System.out.print("\nEnter the volume: ");
		volume = InputRead.getInt();
//		while (volume <= 0) {
//			System.out.println("\nThe volume cannot be a negative number");
//			volume = InputRead.getInt();
//		}
		System.out.print("\nGenre: ");
		genre = getGenre();
		//shelf.addComic(new Comic(title, genre, volume));
		Comic comic = new Comic(title, genre, volume);
		shelf.addComic(comic);
		System.out.print("\n\nThe comic was added successfully.");
	}

	private String getGenre() {
		Genre genre = new Genre();
		ArrayList<String> availableGenres = new ArrayList<String>(genre.retrieveGenre());
		System.out.println("The available genres for the new comic are: \n\n");
		int i = 0;
		for (String eachGenre : availableGenres) {
			System.out.println(i + " - " + eachGenre);
			i++;
		}
		System.out.print("\n\n------------------------------");
		System.out.print("\nOption: ");
		i = InputRead.getInt();
		return availableGenres.get(i);
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
		if (genre.addGenre(g)) {
			System.out.println("The genre " + g + " has been added.");
		} else {
			System.out.println("The genre " + " already exist.");
		}
	}

	private boolean modifyGenre() {
		return false;
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
