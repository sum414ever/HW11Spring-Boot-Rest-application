package edu.cursor.springREST.repository;

import edu.cursor.springREST.objects.Book;

import java.util.List;

public interface IBookRepository {

    Book addBook(Book book);

    Book refreshBook(String bookId, Book book);

    List<Book> sortByGenre(String genre);

    void deleteBook(String deletedBookId);
}