package com.example.todoList.service;

import com.example.todoList.models.Task;
import com.example.todoList.models.Todolist;

import java.util.ArrayList;

public class TodoListService {

    public ArrayList<Todolist> todolists = new ArrayList<Todolist>();
    public ArrayList<Task> tasks = new ArrayList<Task>();

    {
        this.todolists.add(new Todolist(1,"Animals"));
        this.todolists.add(new Todolist(2,"Cars"));

        this.tasks.add(new Task(1, 1, "Cat", false));
        this.tasks.add(new Task(2, 1, "Dog", false));
        this.tasks.add(new Task(3, 1, "Bat", false));
        this.tasks.add(new Task(4, 2, "Bentley", false));
        this.tasks.add(new Task(5, 2, "Mazda", false));
        this.tasks.add(new Task(6, 2, "Opel", false));
    }

//    public TodoListService() {
//
//    }

//    public ArrayList<Todolist> getTodolists() {
//        return todolists;
//    }
//
//    public ArrayList<Task> getTasks() {
//        return tasks;
//    }
}
