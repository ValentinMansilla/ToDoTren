package com.todotren.todotren.services.impl;

import com.todotren.todotren.config.MappersConfig;
import com.todotren.todotren.entities.ImportanceEntity;
import com.todotren.todotren.entities.StateEntity;
import com.todotren.todotren.entities.TaskEntity;
import com.todotren.todotren.models.Importance;
import com.todotren.todotren.models.State;
import com.todotren.todotren.models.Task;
import com.todotren.todotren.repositories.ImportanceRepository;
import com.todotren.todotren.repositories.StateRepository;
import com.todotren.todotren.repositories.TaskRepository;
import com.todotren.todotren.services.TaskService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private MappersConfig mappersConfig;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private ImportanceRepository importanceRepository;

    @Override
    public List<Task> getAllTasks() {
        return mappersConfig.modelMapper().map(taskRepository.findAll(), new TypeToken<List<Task>>(){}.getType());
    }

    @Override
    @Transactional
    public void newTask(String name, String desc, Importance importance) {
            if (name!=null && !name.isEmpty() && desc!=null && importance!=null){
                Task newTask = new Task();
                newTask.setName(name);
                newTask.setDesc(desc);
                newTask.setDateTime(LocalDateTime.now());

                TaskEntity newEntity = new TaskEntity();
                mappersConfig.modelMapper().map(newTask,newEntity);

                Optional<StateEntity> optionalStateEntity = stateRepository.findByState(State.INITIALIZED);
                if(optionalStateEntity.isPresent()){
                    StateEntity stateEntity = optionalStateEntity.get();
                    newEntity.setState(stateEntity);
                }
                Optional<ImportanceEntity> optionalImportanceEntity = importanceRepository.findByImportance(importance);
                if(optionalStateEntity.isPresent()){
                    ImportanceEntity importanceEntity = optionalImportanceEntity.get();
                    newEntity.setImportance(importanceEntity);
                }
                saveTask(newEntity);
            }
    }

    @Override
    @Transactional
    public Task getByName(String name) {

        Optional<TaskEntity> optionalTaskEntity = taskRepository.findByName(name);

        if(optionalTaskEntity.isPresent()){
            TaskEntity taskEntity = optionalTaskEntity.get();
            return mappersConfig.mergerMapper().map(taskEntity, Task.class);
        }
        else return null;
    }

    private void saveTask(TaskEntity task){
        taskRepository.save(task);
    }

}
