package com.example.spring.demo.repository;

import com.example.spring.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    List<User> findAll();
    void deleteById(Long id);
}
