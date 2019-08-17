package edu.cursor.springREST.repository;

import edu.cursor.springREST.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository implements BookRepositoryInterface {
    List<Book> books = new ArrayList<>();

    @Override
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public Book updateBook(String bookId, Book inputBook) {
        int indexBookInArray = 0;
        Book outputBook = new Book();
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                indexBookInArray = books.indexOf(book);
                outputBook = book;
            }
        }
        outputBook.setTitle(inputBook.getTitle());
        outputBook.setGenre(inputBook.getGenre());
        outputBook.setRating(inputBook.getRating());
        books.add(indexBookInArray, outputBook);
        return outputBook;
    }

    @Override
    public List<Book> sortByGenre(String genre) {
        return books.stream().filter(book -> book.getGenre().equals(genre)).collect(Collectors.toList());
    }

    @Override
    public void deleteBook(String deletedBookId) {
        books.removeIf(book -> book.getId().equals(deletedBookId));
    }
}
