package edu.cursor.spring_data_lesson.service;

import edu.cursor.spring_data_lesson.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorServiceInterface {
    void addAuthor(Author author);

    void deleteAuthor(String id);

    Author getAuthorById(String id);

    List<Author> findAllAuthors();
}
