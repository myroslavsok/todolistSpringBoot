package com.example.todoList.controller;

import com.example.todoList.models.Todolist;
import com.example.todoList.repo.TaskRepo;
import com.example.todoList.repo.TodolistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("lists")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoListController {

    @Autowired
    private TodolistRepo todolistRepo;
    @Autowired
    private TaskRepo taskRepo;

    @GetMapping
    public List<Todolist> getAllLists() {
        return todolistRepo.findAll();
    }

    @GetMapping("{id}")
    public Todolist getListById(@PathVariable Long id) {
        Optional<Todolist> list = todolistRepo.findById(id);
        if (!list.isPresent()) {
            throw new RuntimeException();
        }
        return list.get();
    }

    @PostMapping
    public Todolist addNewList(@RequestBody Todolist list) {
        return todolistRepo.save(list);
    }

    @PatchMapping("{id}")
    public Todolist selectList(@RequestBody Todolist list, @PathVariable Long id) {
        list.setId(id);
        todolistRepo.save(list);
        return list;
    }

    @DeleteMapping("{id}")
    public void deleteList(@PathVariable Long id) {
//        taskRepo.deleteTaskByTodolistId(id);
        todolistRepo.deleteById(id);
    }

}