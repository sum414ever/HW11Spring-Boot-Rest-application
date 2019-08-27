package edu.cursor.spring_data_lesson.service;

import edu.cursor.spring_data_lesson.entity.User;

import java.util.Optional;

public interface UserServiceInterface {
    Optional<User> getUserById(Long id);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    void deleteByUsername(String username);

    void saveUser(User user);
}
