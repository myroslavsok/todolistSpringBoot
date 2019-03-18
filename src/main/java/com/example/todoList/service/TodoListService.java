package com.example.todoList.service;

import com.example.todoList.models.Task;
import com.example.todoList.models.Todolist;

import java.util.ArrayList;

public class TodoListService {

    public ArrayList<Todolist> todolists = new ArrayList<Todolist>();
    public ArrayList<Task> tasks = new ArrayList<Task>();

    {
        Todolist animals = new Todolist("Animals");
        addToList(animals);

        Todolist cars = new Todolist("Cars");
        addToList(cars);


//        this.todolists.add(new Todolist("Animals"));
//        this.todolists.add(new Todolist("Cars"));

//        this.tasks.add(new Task(1, 1, "Cat", false));
//        this.tasks.add(new Task(2, 1, "Dog", false));
//        this.tasks.add(new Task(3, 1, "Bat", false));
//        this.tasks.add(new Task(4, 2, "Bentley", false));
//        this.tasks.add(new Task(5, 2, "Mazda", false));
//        this.tasks.add(new Task(6, 2, "Opel", false));
    }

    public void addToList(Todolist newList) {
        newList.id = this.todolists.size() + 1;
        this.todolists.add(newList);
    }


//    public ArrayList<Todolist> getTodolists() {
//        return todolists;
//    }
//
//    public ArrayList<Task> getTasks() {
//        return tasks;
//    }
}
