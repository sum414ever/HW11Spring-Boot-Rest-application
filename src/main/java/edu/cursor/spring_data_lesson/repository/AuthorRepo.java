package edu.cursor.spring_data_lesson.repository;

import edu.cursor.spring_data_lesson.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,String> {

}
