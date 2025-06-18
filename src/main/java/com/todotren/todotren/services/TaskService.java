package com.todotren.todotren.services;

import com.todotren.todotren.dtos.TaskDTO;
import com.todotren.todotren.models.Importance;
import com.todotren.todotren.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<TaskDTO> getAllTasks();
    TaskDTO getById(Long id);
    TaskDTO updateTask(TaskDTO taskDTO);
}
