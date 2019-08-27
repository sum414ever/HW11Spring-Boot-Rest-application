package edu.cursor.spring_data_lesson.service;

import edu.cursor.spring_data_lesson.entity.Book;

import java.util.List;

public interface BookServiceInterface {
    Book addBook(Book book);

    List<Book> sortByGenre(String genre);

    void deleteBook(Long id);
}
