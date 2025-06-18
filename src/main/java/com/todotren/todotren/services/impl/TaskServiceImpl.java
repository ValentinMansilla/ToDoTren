package com.todotren.todotren.services.impl;

import com.todotren.todotren.config.MappersConfig;
import com.todotren.todotren.dtos.TaskDTO;
import com.todotren.todotren.entities.ImportanceEntity;
import com.todotren.todotren.entities.StateEntity;
import com.todotren.todotren.entities.TaskEntity;
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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**Class that implements the TaskService.
 * @see TaskService
 * */
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

    /**Method to bring a list of all tasks from the database.
     * @see MappersConfig
     * @return a complete list of tasks.
     * */
    @Override
    public List<TaskDTO> getAllTasks() {
        return mappersConfig.mergerMapper().map(mappersConfig.modelMapper().map(taskRepository.findAll(), new TypeToken<List<Task>>(){}.getType()), new TypeToken<List<TaskDTO>>(){}.getType());
    }

    /**Method to create a new task or update an existing one. If the param has an id it will update it.If not, it will create it.Then, it will save it on database.
     * @param taskDTO defines the function of the method.
     * @return a saved task with its new data.
     * */
    @Override
    @Transactional
    public TaskDTO updateTask(TaskDTO taskDTO) {
        TaskEntity saved = new TaskEntity();
        StateEntity state = new StateEntity();
        ImportanceEntity importance = new ImportanceEntity();


        if(taskDTO.getId()!=null){

                    Optional<TaskEntity> optionalSaved = taskRepository.findById(taskDTO.getId());
                    if (optionalSaved.isPresent()) {
                        saved = optionalSaved.get();
                        saved.setDateTime(saved.getDateTime());
                    }
                    Optional<StateEntity> optionalStateEntity = stateRepository.findByState(taskDTO.getState());
                    if(optionalStateEntity.isPresent()){
                        state = optionalStateEntity.get();
                    }

        }else{

            Optional<StateEntity> optionalStateEntity = stateRepository.findByState(State.INITIALIZED);
            if(optionalStateEntity.isPresent()){
                state = optionalStateEntity.get();
            }

            saved.setDateTime(LocalDateTime.now());

        }

        Optional<ImportanceEntity> optionalImportanceEntity = importanceRepository.findByImportance(taskDTO.getImportance());
        if(optionalImportanceEntity.isPresent()){
            importance = optionalImportanceEntity.get();
        }

        saved.setImportance(importance);
        saved.setName(taskDTO.getName());
        saved.setDesc(taskDTO.getDesc());
        saved.setState(state);
        saved.setId(taskRepository.save(saved).getId());
        return mappersConfig.modelMapper().map(saved, TaskDTO.class);

    }
/**Method to delete a task that already exists.
 * @param id The id of the task that will be deleted.
 */
    @Override
    public void deleteById(Long id) {
        Optional<TaskEntity> optionalSaved = taskRepository.findById(id);
        if (!optionalSaved.isPresent()) {
            throw new RuntimeException("Entity not found");
        }
        taskRepository.deleteById(id);
    }

    /**Method to take a single task from the database
     * @param id The id of the task required.
     * @return a single task.*/
    @Override
    public TaskDTO getById(Long id) {

        Optional<TaskEntity> optionalTaskEntity = taskRepository.findById(id);

        if(optionalTaskEntity.isPresent()){
            TaskEntity taskEntity = optionalTaskEntity.get();
            return mappersConfig.mergerMapper().map(mappersConfig.mergerMapper().map(taskEntity, Task.class),TaskDTO.class);
        }
        else return null;
    }

}
