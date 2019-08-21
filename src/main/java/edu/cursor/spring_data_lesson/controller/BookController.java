package edu.cursor.spring_data_lesson.controller;

import edu.cursor.spring_data_lesson.entity.Book;
import edu.cursor.spring_data_lesson.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("{genre}")
    public ResponseEntity<List<Book>> sortByGenre(@PathVariable("genre") String genre) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.sortByGenre(genre));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBook(@PathVariable("id") String id) {

        bookService.deleteBook(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Book by id " + id + " was deleted successfully");
    }
}
