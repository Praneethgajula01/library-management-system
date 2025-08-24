package com.library.model;

// The Book class represents a book in the library system.
// It implements the Borrowable interface, which means
// this book can be issued to a member and later returned.
public class Book implements Borrowable {

    // ================== Properties (Attributes) ==================
    // These are the details of a Book object.
    // They are private to enforce encapsulation.
    private String id;        // Unique identifier for the book (e.g., "B101")
    private String title;     // Title of the book
    private String author;    // Author of the book
    private boolean isIssued; // Tracks if the book is currently issued (true) or available (false)

    // ================== Constructor ==================
    // This special method is called when we create a new Book object.
    // It initializes the book with an ID, title, author, and sets its status to "available".
    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false; // A new book starts as "Available"
    }

    // ================== Getters ==================
    // These allow other parts of the program to safely access
    // private properties of the Book object.
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    // ================== Borrowable Interface Methods ==================
    // These methods are defined by the Borrowable interface
    // and must be implemented here.

    // Marks the book as issued, only if it's not already issued.
    // Returns true if issuing was successful, otherwise false.
    @Override
    public boolean issue(String memberId) {
        if (!isIssued) {
            isIssued = true;
            return true;
        }
        return false; // Book is already issued
    }

    // Marks the book as returned, only if it was issued before.
    // Returns true if returning was successful, otherwise false.
    @Override
    public boolean returnItem() {
        if (isIssued) {
            isIssued = false;
            return true;
        }
        return false; // Book was already available
    }

    // Returns whether the book is currently issued.
    @Override
    public boolean isIssued() { return isIssued; }

    // ================== Utility Method ==================
    // Provides a human-readable string describing the book.
    // Example: "Clean Code by Robert C. Martin (Available)"
    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}
