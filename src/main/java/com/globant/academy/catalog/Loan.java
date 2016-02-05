package com.globant.academy.catalog;

public class Loan {

	private Comic comic;
	private User usr;

	public Comic getComic() {
		return comic;
	}

	public void setComic(Comic comic) {
		this.comic = comic;
	}

	public User getUsr() {
		return usr;
	}

	public void setUsr(User usr) {
		this.usr = usr;
	}

	@Override
	public String toString() {
		return usr.toString() + comic.toString();
	}
	
	public String display() {
		return this.getComic().getTitle() + " " + "Vol. " + this.getComic().getVolume(); 
	}

	public Loan(Comic comic, User usr) {
		this.comic = comic;
		this.usr = usr;
	}

	@Override
	public boolean equals(Object obj){
		if(getComic().equals(((Loan)obj).getComic()) && getUsr().equals(((Loan)obj).getUsr())){
			return true;
		}
		return false;
	}
}
