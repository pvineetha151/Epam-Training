package com.vin.library;

/**
 * Library Management System
 * @author Vineetha
 *
 */
public class LibraryManagement {
	/**
	 * This main method create the instance of LibraryImpl class to run the application
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(" Welcome to the library!");

		ILibrary lib = new LibraryImpl();
		lib.run();
	}
}
