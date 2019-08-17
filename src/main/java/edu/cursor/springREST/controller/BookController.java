package edu.cursor.springREST.controller;

import edu.cursor.springREST.entity.Book;
import edu.cursor.springREST.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    @ResponseBody
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("{id}")
    public Book updateBook(@PathVariable("id") String id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @GetMapping("{genre}")
    public List<Book> sortByGenre(@PathVariable("genre") String genre) {
        return bookService.sortByGenre(genre);
    }

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable("id") String id) {
        bookService.deleteBook(id);
    }
}
