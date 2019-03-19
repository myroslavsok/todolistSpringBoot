package com.example.todoList.controller;

import com.example.todoList.models.Task;
import com.example.todoList.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskRepo.findById(id);
        if (!task.isPresent()) {
            throw new RuntimeException();
        }
        return task.get();
    }

    @PostMapping
    public Task addNewTask(@RequestBody Task task) {
        return taskRepo.save(task);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> setTaskDone(@RequestBody Task task, @PathVariable Long id) {
        Optional<Task> taskOptional = taskRepo.findById(id);
        if (!taskOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        task.setDone(!task.getDone());
        taskRepo.save(task);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepo.deleteById(id);
    }
}
