package com.example.todoList.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Todolist {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean pin;

    @OneToMany(mappedBy="todolist", cascade = CascadeType.ALL)
    private Set<Task> tasks;

    public Todolist() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String text) {
        this.name = text;
    }

    public String getName() {
        return name;
    }

    public boolean getPin() {
        return pin;
    }

    public void setPin(boolean pin) {
        this.pin = pin;
    }

    public Set<Task> getTasks() {
        return tasks;
    }
    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
