package com.example.todoList.models;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "listId")
    private Long listId;

    @Column(name = "name")
    private String name;

    @Column(name = "done")
    private boolean done;

    public Task(Long id, Long listId, String name, boolean done) {
        this.id = id;
        this.listId = listId;
        this.name = name;
        this.done = done;
    }

    public Task() {}

    public Long getId() {
        return id;
    }

    public Long getListId() {
        return listId;
    }
    public void setListId(Long listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
}