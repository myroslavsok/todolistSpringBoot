package com.example.todoList.models;

import javax.persistence.*;

@Entity
@Table(name = "todolists")
public class Todolist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "pin")
    private boolean pin;

    public Todolist() {}
    public Todolist(String name, boolean pin) {
        this.name = name;
        this.pin = pin;
    }

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
