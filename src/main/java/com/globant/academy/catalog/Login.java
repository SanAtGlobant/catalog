package com.globant.academy.catalog;

import java.util.TreeSet;

public class Login {
	private static TreeSet<User> userList = new TreeSet<User>(new stringComp());
	private static User loggedUser;
	private static String loggedUserPrivilege;

	public void logUser(User u) {
		if (isSheldon(u)) {
			System.out.println(u.getName() + " is now logged in.");
			setLoggedUser(u);
			setLoggedUserPrivilege("Admin");
		} else if (userList.contains(u)) {
			System.out.println(u.getName() + " is now logged in.");
			setLoggedUser(u);
			setLoggedUserPrivilege("User");
		} else {
			System.out.println("The user/password is not valid.");
		}
	}

	private boolean isSheldon(User u) {
		return (u.getName().equalsIgnoreCase("sheldon") && u.getPass().equals("Bazinga"));
	}


	// USERLIST
	public static boolean addUser(User u) {
		if(getLoggedUserPrivilege().equals("Admin")){
			if (userList.add(u)) {
				System.out.println("The user was added successfully.");
				return true;
			} else {
				System.out.println("The user was already created.");
				return false;
			}
		}else{
			System.out.println("Your has no privileges.");
			return false;
		}
	}
	// LOGGED USER
	public static void setLoggedUser(User loggedUser) {
		Login.loggedUser = loggedUser;
	}

	public static User getLoggedUser() {
		return loggedUser;
	}

	public static String getLoggedUserPrivilege() {
		return loggedUserPrivilege;
	}

	public static void setLoggedUserPrivilege(String loggedUserPrivilege) {
		Login.loggedUserPrivilege = loggedUserPrivilege;
	}
}
