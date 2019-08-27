package edu.cursor.spring_data_lesson.repository;

import edu.cursor.spring_data_lesson.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
