package com.globant.academy.catalog;
import java.util.Comparator;

public class LoanComp implements Comparator<Loan> {

	public int compare(Loan l1, Loan l2) {
		return l1.toString().toLowerCase().compareTo(l2.toString().toLowerCase());
	}
}