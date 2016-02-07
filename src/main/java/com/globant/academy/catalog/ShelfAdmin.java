package com.globant.academy.catalog;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ShelfAdmin extends Shelf {

	public void addComic(Comic c) {
		if (getComicList().add(c)) {
		} else {
			getComicList().stream().filter(t -> t.equals(c)).forEach(comic -> comic.setCount(comic.getCount() + 1));
		}
	}

	public boolean removeComic(Comic c) {
		getComicList().stream().filter(t -> t.equals(c)).forEach(comic -> comic.setCount(comic.getCount() - 1));
		if ((getComicList().stream().filter(t -> t.equals(c))).findFirst().get().getCount() == 0) {
			return getComicList().remove(c);
		}
		return false;
	}

	public boolean addLoan(Loan loan) {
		return getLoanList().add(loan);
	}

	public void removeLoan(Loan loan) {
		getLoanList().remove(loan);
	}

	public void increaseBorrowed(Comic c) {
		getComicList().stream().filter(t -> t.equals(c)).forEach(comic -> comic.setBorrowed(comic.getBorrowed() + 1));
	}
	public Loan getLoansRequest() {
		int i = 0;
		ArrayList<Loan> requestedLoans = getLoanRequestList().stream().collect(Collectors.toCollection(ArrayList::new));
		if (!requestedLoans.isEmpty()) {
			System.out.println("The requested loans are:\n");
			for (Loan loan : requestedLoans) {
				System.out.println(i + " - " + loan.display() + " " + loan.getUsr().getName());
				i++;
			}
			System.out.println("-----------------------\n");
			System.out.print("Option: ");
			Loan loanSelected = requestedLoans.get(InputRead.getInt());
			return loanSelected;
		}
		return null;
	}

	public void checkAvailability() {
		for (Loan loan : getLoanRequestList()) {
			if (loan.getComic().getBorrowed() == loan.getComic().getCount()) {
				removeLoanRequest(loan);
			}
		}
	}
}
