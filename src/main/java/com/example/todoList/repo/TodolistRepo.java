package com.example.todoList.repo;

import com.example.todoList.models.Task;
import com.example.todoList.models.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodolistRepo extends JpaRepository<Todolist, Long> {

}