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

    @Column(name = "selected")
    private boolean selected;

    public Todolist() {}
    public Todolist(String name, boolean selected) {
        this.name = name;
        this.selected = selected;
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

    public boolean getSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
