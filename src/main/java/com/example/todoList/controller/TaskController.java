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

    @GetMapping("list/{id}")
    public List<Task> getTaskFromSelectedList(@PathVariable Long id) {
        return taskRepo.findByTodolistId(id);
    }

    @PostMapping
    public Task addNewTask(@RequestBody Task task) {
        return taskRepo.save(task);
    }

    @PatchMapping("{id}")
    public Task setTaskDone(@RequestBody Task task, @PathVariable Long id) {
        task.setId(id);
        taskRepo.save(task);
        return task;
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepo.deleteById(id);
    }
}