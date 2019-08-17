package edu.cursor.springREST.controller;

import edu.cursor.springREST.entity.Author;
import edu.cursor.springREST.entity.Book;
import edu.cursor.springREST.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    @ResponseBody
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @DeleteMapping("{Id}")
    public void deleteAuthor(@PathVariable("Id") String Id) {
        authorService.deleteAuthor(Id);
    }

    @GetMapping("book/{id}")
    public List<Book> filterByAuthor(@PathVariable("id") String id) {
        return authorService.filterByAuthor(id);
    }

    @PutMapping("{id}")
    public Author updateAuthor(@PathVariable("id") String id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }
}

