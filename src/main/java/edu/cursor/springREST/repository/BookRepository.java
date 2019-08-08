package edu.cursor.springREST.repository;

import edu.cursor.springREST.objects.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository implements IBookRepository {
    List<Book> books = new ArrayList<>();

    @Override
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public Book refreshBook(String bookId, Book b) {
        int index = 0;
        Book book = new Book();
        for (Book bu : books) {
            if (bu.getId().equals(bookId)) {
                index = books.indexOf(bu);
                book = bu;
            }
        }
        book.setTitle(b.getTitle());
        book.setGenre(b.getGenre());
        book.setRating(b.getRating());
        books.add(index, book);
        return book;
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
