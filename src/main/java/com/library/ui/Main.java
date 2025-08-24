package com.library.ui;

import com.library.model.*;
import com.library.repository.*;
import com.library.service.*;

public class Main {
    public static void main(String[] args) {
        Repository<Book> bookRepo = new InMemoryBookRepository();
        Repository<Member> memberRepo = new InMemoryMemberRepository();
        LibraryService library = new LibraryService(bookRepo, memberRepo);

        // Add some books
        library.addBook(new Book("B1", "The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book("B2", "Clean Code", "Robert C. Martin"));

        // Add members
        library.addMember(new Member("M1", "Alice"));
        library.addMember(new Member("M2", "Bob"));

        // List books
        System.out.println("All Books:");
        library.listAllBooks();

        // Issue a book
        System.out.println("\nIssuing 'The Hobbit' to Alice...");
        library.issueBook("B1", "M1");

        // Show borrowed books
        System.out.println("\nBorrowed Books:");
        library.showBorrowedBooks();

        // Return book
        System.out.println("\nReturning 'The Hobbit'...");
        library.returnBook("B1");

        // List books again
        System.out.println("\nAll Books after return:");
        library.listAllBooks();
    }
}
