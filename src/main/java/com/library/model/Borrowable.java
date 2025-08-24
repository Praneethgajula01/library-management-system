package com.library.model;

public interface Borrowable {
    boolean issue(String memberId);
    boolean returnItem();
    boolean isIssued();
}
