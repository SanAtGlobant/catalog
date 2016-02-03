package com.globant.academy.catalog;

import java.util.Scanner;
import java.util.TreeSet;

public class Login {
	private static TreeSet<User> userList = new TreeSet<User>(new stringComp());
//	private static TreeSet<User> userList = new TreeSet<User>(); NO FUNCIONO
	private static User loggedUser;
	private static String loggedUserPrivilege;
	private static Scanner s = new Scanner(System.in);

	public void logUser(User u) {
		userList.add(new User("Luca", "Luca"));
		if (isSheldon(u)) {
			System.out.println(u.getName() + " is now logged in.");
			setLoggedUser(new Admin());
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
	public boolean addUser() {
		if (getLoggedUserPrivilege().equals("Admin")) {
			String usr, pss;
			System.out.print("\nUser: ");
			usr = s.next();
			System.out.print("\nPassword: ");
			pss = s.next();
			User user = new User(usr, pss);
			if (userList.add(user)) {
				System.out.println("The user was added successfully.");
				return true;
			} else {
				System.out.println("The user was already created.");
				return false;
			}
		} else {
			System.out.println("Your has no privileges.");
			return false;
		}
	}

	public boolean deleteUser() {

		if (getLoggedUserPrivilege().equals("Admin")) {
			String usr, pss;
			System.out.print("\nUser: ");
			usr = s.next();
			System.out.print("\nPassword: ");
			pss = s.next();
			User user = new User(usr, pss);
			if (userList.remove(user)) {
				System.out.println("The user was added successfully.");
				return true;
			} else {
				System.out.println("The user was already created.");
				return false;
			}
		} else {
			System.out.println("Your user has no privileges.");
			return false;
		}
	}
	
	
	public void displayUsers() {
		if (getLoggedUserPrivilege().equals("Admin")) {
			System.out.println(userList);
		}else{
			System.out.println("Your user has no privileges.");
		}
	}
	
	public void logOut(){
		setLoggedUser(null);
		setLoggedUserPrivilege(null);
	}

	// LOGGED USER
	public  void setLoggedUser(User loggedUser) {
		Login.loggedUser = loggedUser;
	}

	public  User getLoggedUser() {
		return loggedUser;
	}

	public String getLoggedUserPrivilege() {
		return loggedUserPrivilege;
	}

	public void setLoggedUserPrivilege(String loggedUserPrivilege) {
		Login.loggedUserPrivilege = loggedUserPrivilege;
	}
}
