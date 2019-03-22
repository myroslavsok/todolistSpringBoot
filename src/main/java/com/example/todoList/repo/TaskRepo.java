package com.example.todoList.repo;

import com.example.todoList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByTodolistId(Long id);

//    @Query(value = "SELECT task FROM task")
//    List<Task> findAllTasks();

//    @Transactional
//    void deleteTaskByTodolistId(Long id);

//    get only false tasks
//    SELECT *
//    FROM task
//    INNER JOIN todolist
//    ON task.todolist_id = todolist.id AND task.done = false;
}