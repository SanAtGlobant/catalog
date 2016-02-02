package com.globant.academy.catalog;

public class App 
{	
    public static void main( String[] args )
    {
    	User usuario = new User("jose", "pepe");
    	Menu menu = new Menu();
    	
    	menu.initial();
    	menu.guestAccess();
    }
}
