package edu.cursor.springREST.service;

import edu.cursor.springREST.objects.Book;
import edu.cursor.springREST.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {
    private final IBookRepository iBookRepository;

    public Book addBook(Book book) {
        return iBookRepository.addBook(book);
    }

    public Book refreshBook(String bookId, Book b) {
        Book book = new Book();
        book.setTitle(b.getTitle());
        book.setGenre(b.getGenre());
        book.setRating(b.getRating());
        return iBookRepository.refreshBook(bookId, book);
    }

    public List<Book> sortByGenre(String genre) {
        return iBookRepository.sortByGenre(genre);
    }

    public void deleteBook(String deletedBookId) {
        iBookRepository.deleteBook(deletedBookId);
    }
}
