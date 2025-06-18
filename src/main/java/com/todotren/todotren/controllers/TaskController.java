package com.todotren.todotren.controllers;

import com.todotren.todotren.config.MappersConfig;
import com.todotren.todotren.dtos.TaskDTO;
import com.todotren.todotren.models.Importance;
import com.todotren.todotren.models.State;
import com.todotren.todotren.models.Task;
import com.todotren.todotren.services.TaskService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/getall")
    public List<TaskDTO> alltasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/getbyid")
    public TaskDTO taskById(@RequestParam Long id){

        return taskService.getById(id);
    }
    @PutMapping("/updatetask")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO){

        return ResponseEntity.ok(taskService.updateTask(taskDTO));
    }
    @DeleteMapping("/deletebyid")
    public ResponseEntity<String> deleteById(@RequestParam Long id){
        taskService.deleteById(id);
        return ResponseEntity.ok("Task successfully deleted");
    }


}
