package edu.cursor.springREST.repository;

import edu.cursor.springREST.entity.Author;
import edu.cursor.springREST.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Repository
public class AuthorRepository implements AuthorRepositoryInterface {
    List<Author> authors = new ArrayList<>();

    @Override
    public Author addAuthor(Author author) {
        authors.add(author);
        return author;
    }

    @Override
    public void deleteAuthor(String deletedAuthorId) {
        authors.removeIf(author -> author.getId().equals(deletedAuthorId));
    }

    @Override
    public List<Book> filterByAuthor(String authorId) {
        Optional<List<Book>> books = authors.stream()
                .filter(author -> author.getId().equals(authorId))
                .map(Author::getBooks).findFirst();

        return books.orElse(Collections.EMPTY_LIST);
    }

    @Override
    public Author updateAuthor(String authorId, Author inputAuthor) {
        int indexAuthorInArray = 0;
        Author outputAuthor = new Author();
        for (Author author : authors) {
            if (author.getId().equals(authorId)) {
                indexAuthorInArray = authors.indexOf(author);
                outputAuthor = author;
            }
        }
        outputAuthor.setFirstName(inputAuthor.getFirstName());
        outputAuthor.setLastName(inputAuthor.getLastName());
        authors.add(indexAuthorInArray, outputAuthor);
        return outputAuthor;
    }
}
