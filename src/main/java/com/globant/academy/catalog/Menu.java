package com.globant.academy.catalog;

import java.util.Scanner;

public class Menu {

	private Scanner scan= new Scanner(System.in);
	private MenuView menuView = new MenuView();

	public void callMenu() {

		boolean salir = false;
		int option;
		
		while (!salir) {

			menuView.initial();
			option = scan.nextInt();
			
			switch(){
			case 1:
			}
		}
	}
}
