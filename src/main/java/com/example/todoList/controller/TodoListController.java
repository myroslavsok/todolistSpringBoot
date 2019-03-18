package com.example.todoList.controller;

import com.example.todoList.models.Todolist;
import com.example.todoList.service.TodoListService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("list")
//@CrossOrigin

public class TodoListController {

    private TodoListService todoListService = new TodoListService();


    @GetMapping
    public ArrayList<Todolist> getAllLists() {
        return this.todoListService.todolists;
    }

    @GetMapping("{id}")
    public Optional<Todolist> getOneLists(@PathVariable long id) {
         return this.todoListService.todolists.stream()
                .filter(list -> list.id == id)
                .findFirst();
    }

    @PostMapping
    public ArrayList<Todolist> addNewList() {

    }






//    @GetMapping("list")
//    @ResponseBody
//    ArrayList<Todolist> getAllLists() {
//        return this.todoListService.getTodolists();
//    }

//    @GetMapping(value = "list")
//    @ResponseBody
//    ArrayList<Todolist> getAllLists(@) {
//        return this.todoListService.getTodolists();
//    }



}
