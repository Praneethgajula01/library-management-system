// Main.java (console demo)
public class Main {
    public static void main(String[] args) {
        // Create a new instance of our Library.
        LibraryService library = new LibraryService();

        // Add some books and members to get started.
        library.addBook(new Book("B1", "The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book("B2", "Clean Code", "Robert C. Martin"));
        library.addMember(new Member("M1", "Alice"));
        library.addMember(new Member("M2", "Bob"));

        // Step 1: Show all books initially.
        System.out.println("All Books:");
        library.listAllBooks();

        // Step 2: Simulate issuing a book.
        System.out.println("\nIssuing 'The Hobbit' to Alice...");
        library.issueBook("B1", "M1");

        // Step 3: Check which books are currently borrowed.
        System.out.println("\nBorrowed Books:");
        library.showBorrowedBooks();

        // Step 4: Simulate returning the book.
        System.out.println("\nReturning 'The Hobbit'...");
        library.returnBook("B1");

        // Step 5: Show all books again to confirm the book is now available.
        System.out.println("\nAll Books after return:");
        library.listAllBooks();
    }
}