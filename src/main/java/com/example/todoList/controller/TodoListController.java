package com.example.todoList.controller;

import com.example.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class TodoListController {

//    @Autowired
//    TodoListService todoListService;

    @GetMapping(value = "/hi")
    @ResponseBody
    String hi() {
        return "test";
    }



}
