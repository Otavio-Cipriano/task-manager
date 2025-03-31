package com.example.task_manager.services;

import com.example.task_manager.DTO.TasksDTO;
import com.example.task_manager.domain.models.Task;

import java.util.List;

public interface TaskService {
    Task create(Task task);

    Task findById(Long id);

    List<TasksDTO> getTasks();

    Task deleteById(Long id);
}
