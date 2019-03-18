package com.example.todoList.models;

public class Task {
    private long id;
    private long listId;
    private String name;
    private boolean done;

    public Task(long id, long listId, String name, boolean done) {
        this.id = id;
        this.listId = listId;
        this.name = name;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public long getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }
}
