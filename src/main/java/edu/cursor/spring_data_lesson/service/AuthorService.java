package edu.cursor.spring_data_lesson.service;

import edu.cursor.spring_data_lesson.entity.Author;
import edu.cursor.spring_data_lesson.exceptions.DataNotFoundException;
import edu.cursor.spring_data_lesson.repository.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService implements AuthorServiceInterface {
    private final AuthorRepo authorRepo;

    @Override
    public void addAuthor(Author author) {
        authorRepo.save(author);
    }

    @Override
    public void deleteAuthor(String id) {
        authorRepo.deleteById(id);
    }

    @Override
    public Author getAuthorById(String id) {
        return authorRepo.findById(id).orElseThrow(() -> new DataNotFoundException("Not found"));
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepo.findAll();
    }
}
