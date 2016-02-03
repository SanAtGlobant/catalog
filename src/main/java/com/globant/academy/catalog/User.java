package com.globant.academy.catalog;

public class User {

	protected String name;
	protected String pass;

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	public User(){
		
	}
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return name + pass;
	}

}
