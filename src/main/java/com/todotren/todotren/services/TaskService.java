package com.todotren.todotren.services;

import com.todotren.todotren.dtos.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<TaskDTO> getAllTasks();
    TaskDTO getById(Long id);
    TaskDTO updateTask(TaskDTO taskDTO);
    void deleteById(Long id);
}
