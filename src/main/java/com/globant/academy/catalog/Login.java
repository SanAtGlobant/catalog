package com.globant.academy.catalog;
import java.util.TreeSet;

public class Login {
	static TreeSet<User> userList = new TreeSet<User>(new stringComp());
	static User loggedUser;

	public void logUser(User u) {
		if (isSheldon(u)) {
			System.out.println(u.getName() + " is now logged in.");
			setLoggedUser(u);
		} else if (userList.contains(u)) {
			System.out.println(u.getName() + " is now logged in.");
			setLoggedUser(u);
		} else {
			System.out.println(u.getName() + " is not a valid user.");
		}
	}

	private boolean isSheldon(User u) {
		return (u.getName().equalsIgnoreCase("sheldon")&& u.getPass().equals("Bazinga"));
	}

	public static void setLoggedUser(User loggedUser) {
		Login.loggedUser = loggedUser;
	}

	public boolean addUser(String name, String pass) {
		User u = new User(name, pass);
		if (userList.add(u)) {
			System.out.println("The user was added successfully.");
			return true;
		} else {
			System.out.println("The user was already created.");
			return false;
		}
	}

}
