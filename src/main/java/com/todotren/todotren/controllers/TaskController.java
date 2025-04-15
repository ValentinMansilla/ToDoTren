package com.todotren.todotren.controllers;

import com.todotren.todotren.models.Task;
import com.todotren.todotren.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/alltasks")
    public List<Task> alltasks(){
        return taskService.getAllTasks();
    }
}
