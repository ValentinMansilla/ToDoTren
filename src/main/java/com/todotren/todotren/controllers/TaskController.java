package com.todotren.todotren.controllers;

import com.todotren.todotren.config.MappersConfig;
import com.todotren.todotren.dtos.TaskDTO;
import com.todotren.todotren.entities.ImportanceEntity;
import com.todotren.todotren.models.Importance;
import com.todotren.todotren.models.State;
import com.todotren.todotren.models.Task;
import com.todotren.todotren.repositories.ImportanceRepository;
import com.todotren.todotren.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    MappersConfig mappersConfig;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getall")
    public List<Task> alltasks(){
        return taskService.getAllTasks();
    }
    @PutMapping("/newtask")
    public void newTask(@RequestParam String name,
                        @RequestParam String desc,
                        @RequestParam String importance){

       try{
           if(name!=null&&desc!=null&&importance!=null){
               taskService.newTask(name, desc, mappersConfig.modelMapper().map(importance, Importance.class));
           }
       }catch (Exception e){
           System.out.println(e.toString());
       }

    }
    @PutMapping("/updatetask/{name}")
    public ResponseEntity<Task> updateTask(@PathVariable String name, @RequestBody String state){
        Task task = taskService.getByName(name);
        if(task != null){
            task.setState(State.valueOf(state));
            return ResponseEntity.ok(task);
        }
        else return ResponseEntity.notFound().build();
    }

}
