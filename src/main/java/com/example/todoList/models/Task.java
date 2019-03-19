package com.example.todoList.models;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "todolist_id")
    private Long todolistId;

    @Column(name = "name")
    private String name;

    @Column(name = "done")
    private boolean done;

    public Task() {}
    public Task(String name, boolean done) {
        this.todolistId = todolistId;
        this.name = name;
        this.done = done;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getListId() {
        return todolistId;
    }
    public void setListId(Long todolistId) {
        this.todolistId = todolistId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean getDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
}