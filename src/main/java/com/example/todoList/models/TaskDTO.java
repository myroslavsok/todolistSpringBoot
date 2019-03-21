package com.example.todoList.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TaskDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long listId;
    private String name;
    private Boolean done;
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDone() {
        return done;
    }
    public void setDone(Boolean done) {
        this.done = done;
    }

    public Long getListId() {
        return listId;
    }
    public void setListId(Long listId) {
        this.listId = listId;
    }

    public TaskDTO() { }

    public TaskDTO(Long id, String name, boolean done, Long listId) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.listId = listId;
    }

}
