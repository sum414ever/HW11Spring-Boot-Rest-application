package edu.cursor.spring_data_lesson.service;

import edu.cursor.spring_data_lesson.entity.Author;

import javax.transaction.Transactional;
import java.util.List;

public interface AuthorServiceInterface {
    void addAuthor(Author author);

    @Transactional
    void deleteAuthor(Long id);

    Author getAuthorById(Long id);

    List<Author> findAllAuthors();
}
