package com.globant.academy.catalog;

public class User {

	protected String name;
	protected String pass;
	protected Shelf shelf = new Shelf();

	// ***** OPTIONS & MENU *****

	public byte options() {
		System.out.print("\n\n1 - Borrow comic" + "\n2 - Return comic" + "\n3 - View catalog"
				+ "\n4 - Display current loans" + "\n5 - Log out" + "\n0 - Quit application"
				+ "\n----------------------------------" + "\nOption: ");

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
			Shelf.displayCurrentLoans(this);
			break;
		case 5:
			return 0;
		case 0:
			return -1;
		default:
			break;
		}
		return 1;
	}

	private void returnComic() {
		Loan loan = shelf.getLoans(this);
		if (loan == null) {
			return;
		}
		shelf.returnComic(loan);
		shelf.decreaseBorrowed(loan.getComic());
		System.out.println("The comic "+loan.display() + " has been returned.");
	}

	private void borrowComic() {
		Comic comic = this.shelf.getComic();
		if (comic == null) {
			return;
		}
		if (comic.getBorrowed() == comic.getCount()) {
			System.out.println("All the copies are borrowed at the moment.");
		} else if (this.shelf.alreadyBorrowed((new Loan(comic, this)))) {
			System.out.println("You already have a copy of this comic.");
		} else if (this.shelf.addLoanRequest(new Loan(comic, this))) {
			System.out.println("A loan request has been submitted.");
		} else {
			System.out.println("You already have loan request of this comic.");
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
}
