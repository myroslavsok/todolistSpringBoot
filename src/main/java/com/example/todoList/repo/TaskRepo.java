package com.example.todoList.repo;

import com.example.todoList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByTodolistId(Long id);

    @Transactional
    void deleteTaskByTodolistId(Long id);
}