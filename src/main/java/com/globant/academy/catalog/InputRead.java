package com.globant.academy.catalog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputRead {

	private static Scanner s = new Scanner(System.in).useDelimiter("\r\n");

	public static String getLine() {
		String string = s.next();
		if (string.length() > 20) {
			string = string.substring(0, 20);
		}
		return string;
	}

	public static byte getByte() {
		boolean validOption = true;
		byte number = 0;
		while (validOption) {
			try {
				number = s.nextByte();
				validOption = false;
			} catch (InputMismatchException ex) {
				System.out.println("It must be a number.");
				s.next();
			}
		}
		return number;
	}

	public static int getInt() {
		boolean validOption = true;
		int number = 0;
		while (validOption) {
			try {
				number = s.nextInt();
				validOption = false;
			} catch (InputMismatchException ex) {
				System.out.println("It must be a number.");
				s.next();
			}
		}
		return number;
	}

	public static void close() {
		s.close();
	}

}
