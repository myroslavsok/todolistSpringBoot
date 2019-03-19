package com.example.todoList.service;

import com.example.todoList.models.Task;
import com.example.todoList.models.Todolist;
import com.example.todoList.repo.TodolistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoListService {

    @Autowired
    TodolistRepo todolistRepo;

    public List<Todolist> findAllLists() {
        return todolistRepo.findAll();
    }

    public Todolist addNewList(Todolist list) {
        return todolistRepo.save(list);
    }



}
