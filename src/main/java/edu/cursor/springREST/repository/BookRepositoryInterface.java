package edu.cursor.springREST.repository;

import edu.cursor.springREST.entity.Book;

import java.util.List;

public interface BookRepositoryInterface {

    Book addBook(Book book);

    Book updateBook(String bookId, Book book);

    List<Book> sortByGenre(String genre);

    void deleteBook(String deletedBookId);
}