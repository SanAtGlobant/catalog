package com.globant.academy.catalog;

import java.util.Scanner;
import java.util.TreeSet;

public class Login {
	private static TreeSet<User> userList = new TreeSet<User>(new UserComp());
	private static User loggedUser;
	private static String loggedUserPrivilege;

	public void logUser(User u) {
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

	public static boolean addUser(User u){
		if(userList.add(u)){
			return true;
		}else{
			return false;
		}
	}
	public static boolean removeUser(User u){
		if(userList.remove(u)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void displayUsers() {
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

	private static String getLoggedUserPrivilege() {
		return loggedUserPrivilege;
	}

	public void setLoggedUserPrivilege(String loggedUserPrivilege) {
		Login.loggedUserPrivilege = loggedUserPrivilege;
	}
}
