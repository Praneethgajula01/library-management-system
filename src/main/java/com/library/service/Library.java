// Library.java
import java.util.*;

public class Library {
    // We use Maps (like a dictionary in other languages) to store our data.
    // A Map is great for looking up items quickly using a unique key, like a book's ID or a member's ID.
    private Map<String, Book> books = new HashMap<>();       // Stores books, using the book ID as the key.
    private Map<String, Member> members = new HashMap<>();   // Stores members, using the member ID as the key.
    // This Map keeps track of which book is borrowed by which member.
    // The key is the book's ID, and the value is the member's ID.
    private Map<String, String> borrowedBooks = new HashMap<>(); // bookId -> memberId

    // --- Core Library Operations ---

    // Adds a new book to our collection.
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    // Removes a book from the library by its ID.
    public void removeBook(String bookId) {
        books.remove(bookId);
    }

    // Adds a new member to the library.
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    // Removes a member by their ID.
    public void removeMember(String memberId) {
        members.remove(memberId);
    }

    // This method handles the process of issuing a book to a member.
    // It checks if both the book and the member exist and if the book is available.
    // If all conditions are met, it marks the book as issued and records the transaction.
    public boolean issueBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        // Check if the book and member exist and if the book is not already issued.
        if (book != null && member != null && !book.isIssued()) {
            book.issue(); // Update the book's status to "issued."
            borrowedBooks.put(bookId, memberId); // Record who borrowed the book.
            return true; // The operation was successful.
        }
        return false; // Something went wrong (e.g., book or member not found, book already issued).
    }

    // This method handles the return of a book.
    // It checks if the book exists and is currently issued.
    // If it is, it marks the book as returned and removes the transaction record.
    public boolean returnBook(String bookId) {
        Book book = books.get(bookId);
        if (book != null && book.isIssued()) {
            book.returnBook(); // Update the book's status to "available."
            borrowedBooks.remove(bookId); // Remove the transaction record.
            return true; // The operation was successful.
        }
        return false; // The book was not found or wasn't issued.
    }

    // Displays all books that are currently borrowed and who borrowed them.
    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books.");
            return;
        }
        // Loop through each entry in the borrowedBooks map to show the details.
        for (var entry : borrowedBooks.entrySet()) {
            String bookId = entry.getKey();
            String memberId = entry.getValue();
            // Use the IDs to get the actual Book and Member objects and print a nice summary.
            System.out.println(books.get(bookId) + " → Borrowed by " + members.get(memberId));
        }
    }

    // Lists all books currently in the library, showing their availability status.
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        // Loop through all the Book objects stored in our map and print them.
        books.values().forEach(System.out::println);
    }
}
