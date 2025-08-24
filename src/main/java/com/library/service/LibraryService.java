package com.library.service;

import com.library.model.Book;
import com.library.model.Member;
import com.library.repository.Repository;
import java.util.*;

public class LibraryService {
    private Repository<Book> bookRepo;
    private Repository<Member> memberRepo;
    private Map<String, String> borrowedBooks = new HashMap<>();

    public LibraryService(Repository<Book> bookRepo, Repository<Member> memberRepo) {
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
    }

    public void addBook(Book book) { bookRepo.add(book); }
    public void addMember(Member member) { memberRepo.add(member); }

    public boolean issueBook(String bookId, String memberId) {
        Book book = bookRepo.findById(bookId);
        Member member = memberRepo.findById(memberId);

        if (book != null && member != null && book.issue(memberId)) {
            borrowedBooks.put(bookId, memberId);
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookId) {
        Book book = bookRepo.findById(bookId);
        if (book != null && book.returnItem()) {
            borrowedBooks.remove(bookId);
            return true;
        }
        return false;
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books.");
            return;
        }
        borrowedBooks.forEach((bookId, memberId) -> {
            System.out.println(bookRepo.findById(bookId) + " → Borrowed by " + memberRepo.findById(memberId));
        });
    }

    public void listAllBooks() {
        bookRepo.findAll().forEach(System.out::println);
    }
}

