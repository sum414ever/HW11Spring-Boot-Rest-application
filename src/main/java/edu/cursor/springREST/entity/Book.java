package edu.cursor.springREST.entity;

import lombok.Data;

@Data
public class Book {
    private String id;
    private String title;
    private String genre;
    private double rating;
}
