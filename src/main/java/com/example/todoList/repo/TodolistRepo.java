package com.example.todoList.repo;

import com.example.todoList.models.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface TodolistRepo extends JpaRepository<Todolist, Long> {
}