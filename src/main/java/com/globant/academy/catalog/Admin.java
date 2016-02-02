package com.globant.academy.catalog;

public class Admin {

	private final String name = "Sheldon";
	private final String pass = "Bazinga";

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", pass=" + pass + "]";
	}

}
