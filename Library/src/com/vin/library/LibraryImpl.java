package com.vin.library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryImpl implements ILibrary {
	List<String> userList = new ArrayList<String>();
	List<Book> bookList = new ArrayList<Book>();
	Book b;
	int choice;

	static Scanner userInput = new Scanner(System.in);
	Scanner choiceInput = new Scanner(System.in);

	@Override
	public void displayMenu() {
		System.out.println(">########################################################################");
		System.out.println("> Choose one of the options below by typing the corresponding number: ");
		System.out.println(">====================================================================");
		System.out.println("1- Check library list.");
		System.out.println("2- Add a book to the Library.");
		System.out.println("3- Delete a book.");
		System.out.println("4- Blow up library.");
		System.out.println("0- Exit.");
		System.out.println(">########################################################################");
		System.out.println("> Enter your option here: ");
		choice = choiceInput.nextInt();// User inputs a choice (integer).

	}

	@Override
	public void createBook() {
		int isbn;
		String title, author;

		System.out.println("\nEnter Title: ");
		title = userInput.next();

		System.out.println("\nEnter Author: ");
		author = userInput.next();

		System.out.println("\nEnter ISBN: ");
		isbn = userInput.nextInt();

		b = new Book(title, author, isbn);
	}

	@Override
	public void addBook() {
		// create new book object with status "Available."
		bookList.add(b);// add the book to the BookList ArrayList.
		System.out.println("---------------------------------------------------------");
		System.out.println("> You have successfully added the book to the library!\n");
		System.out.println("---------------------------------------------------------");
	}

	@Override
	public void displayBookList() {
		if (bookList.size() == 0) {// If the library is empty, it goes back to main menu and choice.
			System.out.println(">-------------------------------------------------------------");
			System.out.println("> There Library is Emply! Please add a book first!\n");
			System.out.println(">-------------------------------------------------------------");
			displayMenu();// Display to main menu.
			choice = choiceInput.nextInt();// Register new choice.

		} else {
			for (int i = 0; i < bookList.size(); i++) {
				System.out.printf("\n>-----------Book Index: [%s]---------------------------------\n", i + 1);
				System.out.println(bookList.get(i).toString());
				System.out.println(">-------------------------------------------------------------");
			} // End of For Loop.
		} // End of Else Statement.
	}// End of if Statement.

	@Override
	public void removeBook() {
		int i = 0;
		System.out.println("---------------------------------------------------------");
		System.out.println("> Here are all the books registered in the library: ");
		System.out.println("---------------------------------------------------------");

		while (i < bookList.size() && bookList.size() > 0) {// show the user the list of all the books
			System.out.printf("\n> Book number %s:\n%s", i + 1, bookList.get(i));
			i = i + 1;
		} // end of while loop.

		System.out.println("\n\n> Choose an available book from the above list and write down it's number: ");
		int BookChoice = choiceInput.nextInt() - 1;// register user's book choice.

		while (choice == 5) {
			try {
				if (BookChoice > 0 && BookChoice < bookList.size()) {// Check if the book to be borrowed is available.
					// Print the borrowed book information and change the book status to borrowed.
					bookList.remove(BookChoice);
					System.out.printf("\n> You have chosen to delete the following book: %s\n",
							bookList.get(BookChoice));
					System.out.printf("\n> The Book %s is deleted.\n", bookList.get(BookChoice));
					choice = 7;
				}
			} catch (InputMismatchException error) {
				System.out.println("<ERROR> Please enter a number of book from the list: ");
				choiceInput.nextInt();
				choice = 5;
			} catch (IndexOutOfBoundsException error) {
				System.out.println("<ERROR> Please enter a number of book from the list: ");
				choice = 5;
			}
		}
	}

	@Override
	public void emptyLibrary() {
		System.out.println("> WARNING < You have chosen to delete all books in the library! ");
		System.out.println("> Library is being deleted...");
		bookList.clear();
		System.out.println("> Library is Empty!");
		choice = 7;
	}

	@Override
	public void addUser() {
		System.out.println("> Enter your name: ");
		String borrower = userInput.nextLine();
		userList.add(borrower); // Add the userName to the UserList arrayList.
	}

	@Override
	public void run() {
		System.out.println("@TEST@ <<< 1 >>>>");

		addUser();
		System.out.println("@TEST@ <<< 2 >>>>");

		displayMenu();// Displays the main menu and ask for choice.

		System.out.println("@TEST@ <<< 3- Entering main while loop...>>>>");

		exit:

		while (choice != 0) {
			try {
				// Choice 1:
				if (choice == 1 && bookList.size() > 0) {

					displayBookList();
					choice = 7;
				}

				if (choice == 1 && bookList.size() == 0) {
					System.out.println("<ERROR> Library is empty! Please add a Book first!");
					choice = 7;
				}
				// Choice 2:
				if (choice == 2) {
					createBook();
					addBook();
					displayMenu();
				}
				// Choice 5:
				if (choice == 5) {
					removeBook();
					try {
						if (bookList.size() > 0) {
							displayMenu();
						}
					} catch (IndexOutOfBoundsException error) {
						System.out.println("<ERROR> The array is Empty! Please add a book first!");
						choice = 7;
						// break; //Test the Break statement!!!!!!!!!!!!!!!!!!!
					}
				}
				// Choice 6:
				if (choice == 6) {
					emptyLibrary();
				}
				if (choice == 7) {
					displayMenu();
				}
				// Choice 0:
				if (choice == 0) {
					break exit;
				}
			} catch (InputMismatchException error) {
				System.out.println("@TEST@ <<< 5- Breaking from main while loop... >>>>");
				break exit;
			}

		} // end of while loop.

		System.out.println("####  You have Exited the Library!  ####");

	}// End of run() method.
}
