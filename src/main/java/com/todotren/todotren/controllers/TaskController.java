package com.todotren.todotren.controllers;

import com.todotren.todotren.config.MappersConfig;
import com.todotren.todotren.entities.ImportanceEntity;
import com.todotren.todotren.models.Importance;
import com.todotren.todotren.models.Task;
import com.todotren.todotren.repositories.ImportanceRepository;
import com.todotren.todotren.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    ImportanceRepository importanceRepository;
    @Autowired
    MappersConfig mappersConfig;

    @GetMapping("/alltasks")
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
}
