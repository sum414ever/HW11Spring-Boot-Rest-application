package edu.cursor.springREST.entity;

import lombok.Data;

import java.util.List;

@Data
public class Author {
    private String id;
    private String firstName;
    private String lastName;
    private List<Book> books;
}