package edu.cursor.springREST.controller;

import edu.cursor.springREST.objects.Book;
import edu.cursor.springREST.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @RequestMapping(method = RequestMethod.POST, value="book/add")
    @ResponseBody
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.POST, value = "book/refresh/{bookId}")
    public Book refreshAuthor(@PathVariable("bookId") String bookId, @RequestBody Book book) {
        return bookService.refreshBook(bookId, book);
    }

    @RequestMapping(method = RequestMethod.GET, value = "book/sort/{genre}")
    public List<Book> sortByGenre(@PathVariable("genre") String genre) {
        return bookService.sortByGenre(genre);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "book/{deletedAuthorId}")
    public void deleteAuthor(@PathVariable("deletedBookId") String deletedBookId) {
        bookService.deleteBook(deletedBookId);
    }
}
