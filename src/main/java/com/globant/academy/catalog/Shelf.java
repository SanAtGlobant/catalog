package com.globant.academy.catalog;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Shelf {
	private static TreeSet<Comic> comicList = new TreeSet<Comic>(new ComicComp());
	private static TreeSet<Loan> loanList = new TreeSet<Loan>(new LoanComp());
	private static TreeSet<Loan> loanRequestList = new TreeSet<Loan>(new LoanComp());

	public void addComic(Comic c) {
		if (comicList.add(c)) {
		} else {
			comicList.stream().filter(t -> t.equals(c)).forEach(comic -> comic.setCount(comic.getCount() + 1));
		}
	}

	public boolean removeComic(Comic c) {
		return comicList.remove(c);
	}

	public static TreeSet<Comic> getComicList() {
		return comicList;
	}

	public static void displayComics() {
//		System.out.printf("%12s" + "%12s" + "%12s" + "%12s" + "%12s", "Genre", "Title", "Volume", "Count",
//				"Borrowed\n\n");
		for (Comic e : comicList) {
			 System.out.println(e.getGenre() + " " + e.getTitle() + " " +
			 e.getVolume() + " " + e.getCount() + " " + e.getBorrowed());
//			System.out.printf("%12s" + "%12s" + "%6d" + "%6d" + "%6d", e.getGenre(), e.getTitle(), e.getVolume(),
//					e.getCount(), e.getBorrowed() + "\n" );
		}
		System.out.println("------------------------");
	}

	public boolean addLoan(Loan loan) {
		return loanList.add(loan);
	}

	public void removeLoan(Loan loan) {
		loanList.remove(loan);
	}

	public String getGenre() {
		Genre genre = new Genre();
		ArrayList<String> availableGenres = new ArrayList<String>(genre.retrieveGenre());
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

	public Comic getComic() {
		String genre = getGenre();
		ArrayList<Comic> availableComics = new ArrayList<Comic>(Shelf.getComicList());
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
	}

	public void returnComic(Loan loan) {
		loanList.remove(loan);
	}

	public Loan getLoans(User user) {
		System.out.println("Your current loans are:\n");
		int i = 0;
		ArrayList<Loan> currentLoans = loanList.stream().filter(t -> t.getUsr().equals(user))
				.collect(Collectors.toCollection(ArrayList::new));
		for (Loan loan : currentLoans) {
			System.out.println(i + " - " + loan.display());
			i++;
		}
		System.out.println("-----------------------\n");
		System.out.print("Option: ");
		Loan loanSelected = currentLoans.get(InputRead.getInt());
		decreaseBorrowed(loanSelected.getComic());
		return loanSelected;
	}

	public void decreaseBorrowed(Comic c) {
		comicList.stream().filter(t -> t.equals(c)).forEach(comic -> comic.setBorrowed(comic.getBorrowed() - 1));
	}

	public void increaseBorrowed(Comic c) {
		comicList.stream().filter(t -> t.equals(c)).forEach(comic -> comic.setBorrowed(comic.getBorrowed() + 1));
	}
}
