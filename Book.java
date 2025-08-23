// Book.java
public class Book {
    // These are the properties (or attributes) of a Book object.
    // They are "private" to ensure they can only be accessed and modified through this class's methods.
    private String id;
    private String title;
    private String author;
    private boolean isIssued;

    // This is the constructor. It's a special method called when we create a new Book object.
    // It initializes the book with an ID, title, and author, and sets its status to "available" by default.
    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false; // A newly created book is always available.
    }

    // These are "getter" methods. They allow other parts of the program to read the private properties.
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    // These are "setter" methods. They allow us to change the book's status.
    // We use them to mark a book as issued or returned.
    public void issue() { this.isIssued = true; }
    public void returnBook() { this.isIssued = false; }

    // The toString() method provides a neat, human-readable description of the Book object.
    // When you print a Book object, this is the format that will be used.
    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}