package com.example.spring.demo.repository;

import com.example.spring.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
//    @Query(value = "SELECT * FROM task WHERE status=PENDING", nativeQuery = true)
//    List<Task> viewPendingTask();

    @Query(value = "SELECT * FROM user_task WHERE status=?", nativeQuery = true)
    List<Task> viewByStatus(String status);

//    @Query(value = "SELECT * FROM task WHERE status=OPEN", nativeQuery = true)
//    List<Task> viewAllTaskInProgress();
}
