package com.example.todoList.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//    @OneToMany(mappedBy = "todolist",cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Task> tasks = new ArrayList<>();
//public void setTasks(ArrayList<Task> tasks) {
//    this.tasks = tasks;
//}
//    public List<Task> getTasks() {
//        return tasks;
//    }

@Entity
public class Todolist {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean pin;

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
}
