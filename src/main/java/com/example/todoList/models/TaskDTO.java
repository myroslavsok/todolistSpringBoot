package com.example.todoList.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class TaskDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long listId;
    private String name;
    private Boolean done;
    private Long id;

    public TaskDTO() { }

    public TaskDTO(Long id, String name, boolean done, Long listId) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.listId = listId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    static public class Transffering {
        public static List<TaskDTO> transferTasksToTaskDTOs(List<Task> tasks) {
            List<TaskDTO> taskDTOs = new ArrayList<TaskDTO>();
            tasks.forEach(task -> {
                Long listId = task.getTodolist().getId();
                TaskDTO newTaskDTO = new TaskDTO(task.getId(), task.getName(), task.getDone(), listId);
                taskDTOs.add(newTaskDTO);
            });
            return taskDTOs;
        }
    }

}
