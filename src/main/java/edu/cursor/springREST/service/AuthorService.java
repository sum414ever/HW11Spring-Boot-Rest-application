package edu.cursor.springREST.service;

import edu.cursor.springREST.entity.Author;
import edu.cursor.springREST.entity.Book;
import edu.cursor.springREST.repository.AuthorRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepositoryInterface iAuthorRepository;

    public Author addAuthor(Author a) {
        Author author = new Author();
        author.setId(a.getId());
        author.setFirstName(a.getFirstName());
        author.setLastName(a.getLastName());
        author.setBooks(new ArrayList<>());
        return iAuthorRepository.addAuthor(author);
    }

    public void deleteAuthor(String deletedAuthorId) {
        iAuthorRepository.deleteAuthor(deletedAuthorId);
    }

    public List<Book> filterByAuthor(String authorId) {
        return iAuthorRepository.filterByAuthor(authorId);
    }


    public Author updateAuthor(String authorId, Author a) {
        Author author = new Author();
        author.setId(a.getId());
        author.setFirstName(a.getFirstName());
        author.setLastName(a.getLastName());
        return iAuthorRepository.updateAuthor(authorId, author);
    }
}
