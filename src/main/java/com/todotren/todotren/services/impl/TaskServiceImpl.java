package com.todotren.todotren.services.impl;

import com.todotren.todotren.config.MappersConfig;
import com.todotren.todotren.models.Task;
import com.todotren.todotren.repositories.TaskRepository;
import com.todotren.todotren.services.TaskService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private MappersConfig mappersConfig;

    @Override
    public List<Task> getAllTasks() {
        return mappersConfig.modelMapper().map(taskRepository.findAll(), new TypeToken<List<Task>>(){}.getType());
    }
}
