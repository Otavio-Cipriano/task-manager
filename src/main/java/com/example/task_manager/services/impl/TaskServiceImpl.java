package com.example.task_manager.services.impl;

import com.example.task_manager.DTO.TasksDTO;
import com.example.task_manager.domain.models.Task;
import com.example.task_manager.domain.repositories.TaskRepository;
import com.example.task_manager.services.TaskService;
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
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
