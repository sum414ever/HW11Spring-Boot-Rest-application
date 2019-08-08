package edu.cursor.springREST.repository;

import edu.cursor.springREST.objects.Author;
import edu.cursor.springREST.objects.Book;

import java.util.List;

public interface IAuthorRepository {

    Author addAuthor(Author author);

    void deleteAuthor(String deletedAuthorId);

    List<Book> sortByAuthor(String authorId);

    Author refreshAuthor(String authorId, Author author);
}
