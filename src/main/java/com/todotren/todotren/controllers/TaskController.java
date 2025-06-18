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

/** Controller class for the endppoints of the tasks.
 * @see TaskDTO
 * @see com.todotren.todotren.services.impl.TaskServiceImpl
 * */
@RestController
@RequestMapping("/tasks")
public class TaskController {


    @Autowired
    TaskService taskService;

    /** Endpoint that brings a list of all tasks from database.
     * @return all the tasks.
     * */
    @GetMapping("/getall")
    public List<TaskDTO> alltasks(){
        return taskService.getAllTasks();
    }
    /** Endpoint that brings a task by its id from database.
     * @see TaskDTO
     * @return a single TaskDTO.
     * @param id is the id of the task required.
     * */
    @GetMapping("/getbyid")
    public TaskDTO taskById(@RequestParam Long id){

        return taskService.getById(id);
    }
    /** Endpoint that add a new task to the database or modify an existing one.
     * @return a single updated task.
     * @param taskDTO request the data to create the task.
     * */
    @PutMapping("/updatetask")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO){

        return ResponseEntity.ok(taskService.updateTask(taskDTO));
    }
    /** Endpoint that delete a single task by its id.
     * @param id is the id of the task required.
     * */
    @DeleteMapping("/deletebyid")
    public ResponseEntity<String> deleteById(@RequestParam Long id){
        taskService.deleteById(id);
        return ResponseEntity.ok("Task successfully deleted");
    }


}
