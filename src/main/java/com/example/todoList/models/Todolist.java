package com.example.todoList.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todolist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Todolist(String name) {
        this.name = name;
    }

    public void setName(String text) {
        this.name = text;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
