package com.globant.academy.catalog;

public class Admin extends User {
	
	private ShelfAdmin shelfAdmin;

	public Admin() {
		super();
		name = "Sheldon";
		pass = "Bazinga";
		shelfAdmin = new ShelfAdmin();
	}

	// ***** MENU METHODS *****

	public byte options() {
		System.out.print("\n\n1 - Add user" + "\n2 - Delete user" + "\n3 - Display users" + "\n4 - Add comic"
				+ "\n5 - Delete comic" + "\n6 - View catalog" + "\n7 - Add genre" + "\n8 - Delete genre"
				+ "\n9 - Approve or reject loans" + "\n10 - Log out" + "\n0 - Quit application" + "\n----------------------------------" + "\nOption: ");

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
			approveLoans();
			break;
		case 10:
			return 0;
		case 0:
			return -1;
		default:
			System.out.println("The option is invalid.");
			break;
		}
		return 1;
	}

	private void approveLoans() {
		Loan selectedLoan = shelfAdmin.getLoansRequest();
		byte option = 0;
		if(selectedLoan!=null){
			System.out.println("Provide an action for the loan request "+ selectedLoan.display());
			System.out.println("0 - Approve\n1 - Reject\n---------------------\nOption: ");
			option = InputRead.getByte();
			switch(option){
			case 0:
				shelfAdmin.addLoan(selectedLoan);
				shelfAdmin.removeLoanRequest(selectedLoan);
				System.out.println("The request has been approved.");
				shelfAdmin.increaseBorrowed(selectedLoan.getComic());
				shelfAdmin.checkAvailability();
				break;
			case 1:
				shelfAdmin.removeLoanRequest(selectedLoan);
				System.out.println("The request has been rejected.");
			}
		}else{
			System.out.println("There are no request at the moment.");
		}
		
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
		if (Login.removeUser(new User(usr, pss))) {
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
		//System.out.print("\nGenre: ");
		String genre = shelfAdmin.getGenre();
		while(genre == null){
			addGenre();
			genre = shelfAdmin.getGenre();
		}
		shelfAdmin.addComic(new Comic(title, genre, volume));
		System.out.print("\n\nThe comic was added successfully.");
	}

	private void removeComic() {
		Comic comicToDelete = shelfAdmin.getComic();
		if(comicToDelete==null){
			return;
		}
		if(comicToDelete.getCount()>comicToDelete.getBorrowed()){
		shelfAdmin.removeComic(comicToDelete);
		System.out.println("The comic "+ comicToDelete.getTitle() + " Vol. " + comicToDelete.getVolume() + " has been deleted.");
		}else{
		System.out.println("All the exemplars for "+ comicToDelete.getTitle() + " Vol. " + comicToDelete.getVolume() + " are currently borrowed.");
		System.out.println("It cannot be deleted.");
		}
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
		String genreToDelete = shelfAdmin.getGenre();
		if(genreToDelete==null){
			return;
		}
		Genre genre = new Genre();
		if(Shelf.getComicList().stream().noneMatch(comic -> comic.getGenre().equals(genreToDelete))){
			genre.removeGenre(genreToDelete);
			System.out.println("The genre has been deleted.");
		}else{
			System.out.println("There are comics tagged with this genre. It cannot be deleted.");
		}
}
}