package com.library.repository;

import com.library.model.Book;
import java.util.*;

public class InMemoryBookRepository implements Repository<Book> {
    private Map<String, Book> books = new HashMap<>();

    @Override
    public void add(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public void remove(String id) {
        books.remove(id);
    }

    @Override
    public Book findById(String id) {
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}
