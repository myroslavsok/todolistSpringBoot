package com.example.todoList.controller;

import com.example.todoList.models.Todolist;
import com.example.todoList.repo.TodolistRepo;
import com.example.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RequestMapping("lists")
//@CrossOrigin
//@Controller

@RestController
@RequestMapping("/lists")
public class TodoListController {

    @Autowired
    private TodolistRepo todolistRepo;

    private TodoListService todoListService;

    public TodoListController() {
    }

    @GetMapping
    public List<Todolist> findAllLists() {
        return todolistRepo.findAll();
    }

    @PostMapping
    public Todolist add(@RequestBody Todolist list) {
        return todolistRepo.save(list);
    }

}