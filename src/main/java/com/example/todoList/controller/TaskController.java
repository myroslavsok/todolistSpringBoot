package com.example.todoList.controller;

import com.example.todoList.models.Task;
import com.example.todoList.models.TaskDTO;
import com.example.todoList.models.Todolist;
import com.example.todoList.repo.TaskRepo;
import com.example.todoList.repo.TodolistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tasks")
//@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

//    @Resource(name="sessionFactory")
//    private SessionFactory sessionFactory;

    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private TodolistRepo todolistRepo;

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepo.findAll();
        List<TaskDTO> taskDTOs = new ArrayList<TaskDTO>();
        tasks.forEach(task -> {
            Long listId = task.getTodolist().getId();
            TaskDTO newTaskDTO = new TaskDTO(task.getId(), task.getName(), task.getDone(), listId);
            taskDTOs.add(newTaskDTO);
        });
        return taskDTOs;
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskRepo.findById(id);
        if (!task.isPresent()) {
            throw new RuntimeException();
        }
        return task.get();
    }

    @GetMapping("list/{id}")
    public List<Task> getTaskFromSelectedList(@PathVariable Long id) {
        return taskRepo.findByTodolistId(id);
    }

    @GetMapping("false")
    public List<Task> getUndoneTasksFromList() {
        return taskRepo.findAll()
                    .stream()
                    .filter(task -> !task.getDone())
                    .collect(Collectors.toList());
    }

    @PostMapping
    public Task addNewTask(@RequestBody TaskDTO taskDTO) throws Exception {
        Todolist list = this.todolistRepo.findById(taskDTO.getListId()).orElseThrow(Exception::new);
        return taskRepo.save(new Task(taskDTO.getListId(), taskDTO.getName(), taskDTO.getDone(), list));
    }

    @PatchMapping("{id}")
    public Task renameTask(@RequestBody Task task, @PathVariable Long id) {
//        // Retrieve session from Hibernate
//        Session session = sessionFactory.getCurrentSession();
//        // Retrieve existing person via id
//        Task existingPerson = (Task) session.get(Task.class, Task.getId());
        task.setId(id);
        taskRepo.save(task);
        return task;
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepo.deleteById(id);
    }
}
