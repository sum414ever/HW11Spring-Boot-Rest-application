package edu.cursor.spring_data_lesson.controller;

import edu.cursor.spring_data_lesson.entity.Author;
import edu.cursor.spring_data_lesson.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteAuthor(@PathVariable("id") String id) {
        authorService.deleteAuthor(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Author by id " + id + " was deleted successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") String id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorService.getAuthorById(id));
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAllAuthors() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorService.findAllAuthors());
    }
}
