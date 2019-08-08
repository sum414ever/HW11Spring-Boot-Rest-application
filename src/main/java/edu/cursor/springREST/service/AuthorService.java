package edu.cursor.springREST.service;

import edu.cursor.springREST.objects.Author;
import edu.cursor.springREST.objects.Book;
import edu.cursor.springREST.repository.IAuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final IAuthorRepository iAuthorRepository;

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

    public List<Book> sortByAuthor(String authorId) {
        return iAuthorRepository.sortByAuthor(authorId);
    }


    public Author refreshAuthor(String authorId, Author a) {
        Author author = new Author();
        author.setId(a.getId());
        author.setFirstName(a.getFirstName());
        author.setLastName(a.getLastName());
        return iAuthorRepository.refreshAuthor(authorId, author);
    }
}
