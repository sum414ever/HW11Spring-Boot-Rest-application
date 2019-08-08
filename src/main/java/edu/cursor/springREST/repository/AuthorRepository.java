package edu.cursor.springREST.repository;

import edu.cursor.springREST.objects.Author;
import edu.cursor.springREST.objects.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AuthorRepository implements IAuthorRepository {
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
    public List<Book> sortByAuthor(String authorId) {
        List<Book> books = new ArrayList<>();
        for (Author a : authors) {
            if (a.getId().equals(authorId)) {
                books = a.getBooks();
            }
        }
        return books;
    }

    @Override
    public Author refreshAuthor(String authorId, Author a) {
        int index = 0;
        Author author = new Author();
        for (Author au : authors) {
            if (au.getId().equals(authorId)) {
                index = authors.indexOf(au);
                author = au;
            }
        }
        author.setFirstName(a.getFirstName());
        author.setLastName(a.getLastName());
        authors.add(index, author);
        return author;
    }
}
