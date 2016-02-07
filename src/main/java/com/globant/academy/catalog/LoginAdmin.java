//package com.globant.academy.catalog;
//
//import java.util.ArrayList;
//import java.util.TreeSet;
//
//public class LoginAdmin extends Login{
//
//	public static boolean addUser(User u){
//		if(getUserList().add(u)){
//			return true;
//		}else{
//			return false;
//		}
//	}
//	public static removeUser(){
//		ArrayList<User> availableUsers = new ArrayList<User>(getUserList());
//		int i = 0;
//		if(!availableUsers.isEmpty()){
//			System.out.println("The available users for deletion are:");
//			for(User usr : availableUsers){
//				System.out.println(i + " - " + usr.getName());
//				i++;
//			}
//			System.out.println("\n------------------------------\n");
//			System.out.println("Option: ");
//			i = InputRead.getByte();
//		}
//		loggedUser.
//	}
//	
//	public static void displayUsers() {
//		if(!getUserList().isEmpty()){
//			getUserList().stream().forEach(usr -> System.out.println(usr.getName()));
//		}else{
//			System.out.println("There are no users loaded.");
//		}
//		
//	}
//	}
