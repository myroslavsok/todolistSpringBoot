package com.example.todoList.models;


public class Todolist {
    private long id;
    private String name;

    public Todolist(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
