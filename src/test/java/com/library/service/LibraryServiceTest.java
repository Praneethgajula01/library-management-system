package com.library.service;

import com.library.model.Book;
import com.library.model.Member;
import com.library.repository.BookRepository;
import com.library.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {

    private LibraryService libraryService;
    private BookRepository bookRepository;
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
        memberRepository = new MemberRepository();
        libraryService = new LibraryService(bookRepository, memberRepository);

        // seed some test data
        bookRepository.addBook(new Book("1", "Clean Code", "Robert Martin"));
        memberRepository.addMember(new Member("101", "Alice"));
    }

    @Test
    void testIssueBookSuccessfully() {
        boolean issued = libraryService.issueBook("1", "101");
        assertTrue(issued, "Book should be issued to member");
    }

    @Test
    void testIssueBookFailsIfAlreadyIssued() {
        libraryService.issueBook("1", "101"); // first issue
        boolean issuedAgain = libraryService.issueBook("1", "101"); // second issue
        assertFalse(issuedAgain, "Book should not be issued again");
    }

    @Test
    void testReturnBookSuccessfully() {
        libraryService.issueBook("1", "101");
        boolean returned = libraryService.returnBook("1", "101");
        assertTrue(returned, "Book should be returned successfully");
    }

    @Test
    void testReturnBookFailsIfNotIssued() {
        boolean returned = libraryService.returnBook("1", "101");
        assertFalse(returned, "Cannot return a book that was not issued");
    }
}

