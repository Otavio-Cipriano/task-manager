package com.example.task_manager.services.impl;

import com.example.task_manager.DTO.TasksDTO;
import com.example.task_manager.domain.models.Task;
import com.example.task_manager.domain.models.TaskState;
import com.example.task_manager.domain.repositories.TaskRepository;
import com.example.task_manager.services.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskServiceImpl implements TaskService {

    final private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<TasksDTO> getTasks(){
        return taskRepository.findAll().stream()
                .map(TasksDTO::new).toList();
    }

    @Override
    public Task deleteById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(NoSuchElementException::new);
        taskRepository.deleteById(id);
        return task;
    }

    @Override
    public List<TasksDTO> getTasksByState(TaskState state) {
        if (state == null){
            throw new IllegalArgumentException("No state provided");
        }
        return taskRepository.findByState(state);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(existingTask -> {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setState(updatedTask.getState());
            return taskRepository.save(existingTask);
        }).orElseThrow(() -> new EntityNotFoundException("Task não encontrada com id: " + id));
    }
}
