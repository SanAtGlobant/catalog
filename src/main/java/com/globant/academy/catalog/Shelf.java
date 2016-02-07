package com.globant.academy.catalog;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Shelf {
	private static TreeSet<Comic> comicList = new TreeSet<Comic>(new ComicComp());
	private static TreeSet<Loan> loanList = new TreeSet<Loan>(new LoanComp());
	private static TreeSet<Loan> loanRequestList = new TreeSet<Loan>(new LoanComp());

	public static TreeSet<Comic> getComicList() {
		return comicList;
	}

	public static TreeSet<Loan> getLoanList() {
		return loanList;
	}

	public static TreeSet<Loan> getLoanRequestList() {
		return loanRequestList;
	}

	public static void displayComics() {
		System.out.printf("%-16s" + " | " + "%-16s" + " | " + "%6s" + " | " + "%5s" + " | " + "%8s" + " | %n", "Genre",
				"Title", "Volume", "Count", "Borrowed");
		System.out.print("-----------------------------------------------------------------\n");
		for (Comic e : comicList) {
			System.out.printf("%-16s" + " | " + "%-16s" + " | " + "%6d" + " | " + "%5d" + " | " + "%8d" + " | %n",
					e.getGenre(), e.getTitle(), e.getVolume(), e.getCount(), e.getBorrowed());
		}
		System.out.println("-----------------------------------------------------------------");
	}

	public String getGenre() {
		Genre genre = new Genre();
		ArrayList<String> availableGenres = new ArrayList<String>(genre.retrieveGenre());
		if (!availableGenres.isEmpty()) {
			System.out.println("The available genres are: \n\n");
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
		System.out.println("There are no genres loaded.\n");
		return null;
	}

	public Comic getComic() {
		String genre = getGenre();
		if (genre == null) {
			return null;
		}
		ArrayList<Comic> availableComics = new ArrayList<Comic>(Shelf.getComicList());
		if (!availableComics.isEmpty()) {
			System.out.println("The available comics are: \n");
			int i = 0;
			for (Comic eachComic : availableComics) {
				if (eachComic.getGenre().equals(genre)) {
					System.out.println(i + " - " + eachComic.getTitle() + "  Vol. " + eachComic.getVolume());
					i++;
				}
			}
			System.out.println("\n------------------------------\n");
			System.out.println("Option: ");
			i = InputRead.getInt();
			return availableComics.get(i);
		} else {
			System.out.println("There are no comics loaded");
			return null;
		}
	}


	public Loan getLoans(User user) {
		int i = 0;
		ArrayList<Loan> currentLoans = loanList.stream().filter(t -> t.getUsr().getName().equals(user.getName()))
				.collect(Collectors.toCollection(ArrayList::new));
		if (!currentLoans.isEmpty()) {
			System.out.println("Your current loans are:\n");
			for (Loan loan : currentLoans) {
				System.out.println(i + " - " + loan.display());
				i++;
				System.out.println("-----------------------\n");
				System.out.print("Option: ");
				Loan loanSelected = currentLoans.get(InputRead.getInt());
				return loanSelected;
			}
		}
		System.out.println("There are no loans.\n");
		return null;
	}

	public static void displayCurrentLoans(User user) {

		if (!loanList.isEmpty()) {
			System.out.println("Your current loans are:\n");
			loanList.stream().filter(t -> t.getUsr().getName().equals(user.getName()))
					.forEach(loan -> System.out.println(loan.display()));
			System.out.println("-----------------------------\n");
		} else {
			System.out.println("Currently you have no active loans.\n");
			System.out.println("-----------------------------\n");
		}
		if (!loanRequestList.isEmpty()) {
			System.out.println("Loans requested:\n");
			loanRequestList.stream().filter(t -> t.getUsr().getName().equals(user.getName()))
					.forEach(loan -> System.out.println(loan.display()));
			System.out.println("-----------------------------\n");
		} else {
			System.out.println("Currently you have no requested loans.\n");
			System.out.println("-----------------------------\n");
		}
	}

	public void decreaseBorrowed(Comic c) {
		comicList.stream().filter(t -> t.equals(c)).forEach(comic -> comic.setBorrowed(comic.getBorrowed() - 1));
	}

	public boolean alreadyBorrowed(Loan loan) {
		return loanList.contains(loan);
	}

	public boolean addLoanRequest(Loan loan) {
		return loanRequestList.add(loan);
	}

	public void removeLoanRequest(Loan loan) {
		loanRequestList.remove(loan);
	}
	public void returnComic(Loan loan) {
		loanList.remove(loan);
	}
}
