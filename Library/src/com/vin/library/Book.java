package com.vin.library;

/**
 * @author Vineetha
 *
 */
public class Book {

	private int isbn;
	private String title, author;

	public Book() {
	}

	public Book(String title, String author, int isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;

	}

	@Override
	public String toString() {
		return "\nTitle: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\n";
	}
}