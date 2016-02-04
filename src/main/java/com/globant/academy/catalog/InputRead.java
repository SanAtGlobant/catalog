package com.globant.academy.catalog;

import java.util.Scanner;

public class InputRead {

	private static Scanner s = new Scanner(System.in);

	public static String getLine() {
		return s.next();
	}

	public static byte getByte() {
		return s.nextByte();
	}
	
	public static void close(){
		s.close();
	}

}
