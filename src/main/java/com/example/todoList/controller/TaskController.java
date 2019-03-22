package com.example.todoList.controller;

import com.example.todoList.models.Task;
import com.example.todoList.models.TaskDTO;
import com.example.todoList.models.Todolist;
import com.example.todoList.repo.TaskRepo;
import com.example.todoList.repo.TodolistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private TodolistRepo todolistRepo;

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepo.findAll();
        return TaskDTO.Transffering.transferTasksToTaskDTOs(tasks);
    }

    @GetMapping("list/{id}")
    public List<TaskDTO> getTaskFromSelectedList(@PathVariable Long id) {
        List<Task> tasks = taskRepo.findByTodolistId(id);
        return TaskDTO.Transffering.transferTasksToTaskDTOs(tasks);
    }

    @PostMapping
    public Task addNewTask(@RequestBody TaskDTO taskDTO) throws Exception {
        Todolist list = todolistRepo.findById(taskDTO.getListId()).orElseThrow(Exception::new);
        return taskRepo.save(new Task(taskDTO.getListId(), taskDTO.getName(), taskDTO.getDone(), list));
    }

    @PatchMapping
    public TaskDTO editTask(@RequestBody TaskDTO taskDTO) throws Exception {
        Task task = taskRepo.findById(taskDTO.getId()).orElseThrow(Exception::new);
        if (taskDTO.getName() != null) {
            task.setName(taskDTO.getName());
        }
        if (taskDTO.getDone() != null) {
            task.setDone(taskDTO.getDone());
        }
        taskRepo.save(task);
        return taskDTO;
    }


    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepo.deleteById(id);
    }

}
