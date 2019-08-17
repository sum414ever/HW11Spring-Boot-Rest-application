package edu.cursor.springREST.service;

import edu.cursor.springREST.entity.Book;
import edu.cursor.springREST.repository.BookRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepositoryInterface iBookRepository;

    public Book addBook(Book book) {
        return iBookRepository.addBook(book);
    }

    public Book updateBook(String id, Book b) {
        Book book = new Book();
        book.setTitle(b.getTitle());
        book.setGenre(b.getGenre());
        book.setRating(b.getRating());
        return iBookRepository.updateBook(id, book);
    }

    public List<Book> sortByGenre(String genre) {
        return iBookRepository.sortByGenre(genre);
    }

    public void deleteBook(String id) {
        iBookRepository.deleteBook(id);
    }
}
