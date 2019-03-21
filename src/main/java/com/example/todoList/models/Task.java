package com.example.todoList.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name = "todolist_id")
//    private Long todolistId;

    private String name;

    private boolean done;

//@NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "todolist_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Todolist todolist;
    public Todolist getTodolist() {
        return todolist;
    }
    public void setTodolist(Todolist todolist) {
        this.todolist = todolist;
    }


    public Task() {}

    public Task(Long id, String name, boolean done, Todolist todolist) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.todolist = todolist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getListId() {
//        return todolistId;
//    }
//    public void setListId(Long todolistId) {
//        this.todolistId = todolistId;
//    }

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