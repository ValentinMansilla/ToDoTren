package com.todotren.todotren.services;

import com.todotren.todotren.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<Task> getAllTasks();
}
