package com.globant.academy.catalog;

public class User {

	protected String name;
	protected String pass;
	protected Shelf shelf = new Shelf();

	// ***** OPTIONS & MENU *****

	public byte options() {
		System.out.print("\n\n1 - Borrow comic" + "\n2 - Return comic" + "\n3 - View catalog" + "\n4 - Log out"
				+ "\n0 - Quit application" + "\n----------------------------------" + "\nOption: ");

		byte selection = InputRead.getByte();
		switch (selection) {
		case 1:
			borrowComic();
			break;
		case 2:
			returnComic();
			break;
		case 3:
			Shelf.displayComics();
			break;
		case 4:
			return 0;
		case 0:
			return -1;
		default:
			break;
		}
		return 1;
	}

	private void returnComic() {
		shelf.returnComic(shelf.getLoans(this));

	}

	private void borrowComic() {
		Comic comic = this.shelf.getComic();
		if (comic.getBorrowed() == comic.getCount()) {
			System.out.println("All the copies are borrowed at the moment.");
		} else if (this.shelf.addLoan(new Loan(comic, this))) {
			this.shelf.increaseBorrowed(comic);
			System.out.println("The comic was borrowed successfully.");
		} else {
			System.out.println("You already have a copy of this comic.");
		}
	}

	// ***** GETTERS & SETTERS *****
	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	// ***** CONSTRUCTOR *****
	public User() {

	}

	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	// ***** TOSTRING *****
	@Override
	public String toString() {
		return name + pass;
	}

	// public boolean equals(User u) { //NO FUNCIONO PARA AGREGAR AL TREESET
	// if (this.toString().equals(u.toString())) {
	// return true;
	// }
	// return false;
	// }

}
