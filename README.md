Library Management System

A simple, console-based Library Management System built in Java. This project demonstrates core object-oriented programming (OOP) principles and data structures like HashMap for efficient data management.


Base Version

Book Management: Add and remove books from the library's collection. Each book has a unique ID, title, and author.
Member Management: Add and remove library members. Each member has a unique ID and a name.
Issuing & Returning: Members can borrow and return books. The system tracks the availability status of each book.


Code Structure

The project is organized into four main classes, each with a single responsibility:

Book.java: Defines the Book object, including its properties (ID, title, author) and methods to manage its availability.
Member.java: Defines the Member object, storing their unique ID and name.
Library.java: The core management class. It contains the logic for managing collections of books and members and handling all library operations like issuing and returning books.
Main.java: The entry point of the application. It acts as a client demo to showcase the functionality of the Library class.
