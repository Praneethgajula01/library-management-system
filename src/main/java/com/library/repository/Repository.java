package com.library.repository;

import java.util.List;

public interface Repository<T> {
    void add(T item);
    void remove(String id);
    T findById(String id);
    List<T> findAll();
}
