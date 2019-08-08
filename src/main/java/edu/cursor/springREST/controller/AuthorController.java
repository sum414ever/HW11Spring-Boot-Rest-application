package edu.cursor.springREST.controller;

import edu.cursor.springREST.objects.Author;
import edu.cursor.springREST.objects.Book;
import edu.cursor.springREST.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @RequestMapping(method = RequestMethod.POST, value = "author/add")
    @ResponseBody
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "author/{deletedAuthorId}")
    public void deleteAuthor(@PathVariable("deletedAuthorId") String deletedAuthorId) {
        authorService.deleteAuthor(deletedAuthorId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "author/book/{authorId}")
    public List<Book> sortByAuthor(@PathVariable("authorId") String authorId) {
        return authorService.sortByAuthor(authorId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "author/refresh/{authorId}")
    public Author refreshAuthor(@PathVariable("authorId") String authorId, @RequestBody Author author) {
        return authorService.refreshAuthor(authorId, author);
    }
}

