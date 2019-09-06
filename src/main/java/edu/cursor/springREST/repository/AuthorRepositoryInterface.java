package edu.cursor.springREST.repository;

import edu.cursor.springREST.entity.Author;
import edu.cursor.springREST.entity.Book;

import java.util.List;

public interface AuthorRepositoryInterface {

    Author addAuthor(Author author);

    void deleteAuthor(String deletedAuthorId);

    List<Book> filterByAuthor(String authorId);

    Author updateAuthor(String authorId, Author author);
}
