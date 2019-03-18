package repository;

import com.example.todoList.models.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TodolistRepository extends JpaRepository <Todolist, Long>{
    ArrayList<Todolist> findByFirstName(String FirstName);
    ArrayList<Todolist> findAll();
}
