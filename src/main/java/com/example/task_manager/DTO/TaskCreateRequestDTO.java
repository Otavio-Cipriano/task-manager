package com.example.task_manager.DTO;

import com.example.task_manager.domain.models.Task;
import com.example.task_manager.domain.models.TaskState;

import java.time.LocalDateTime;

public record TaskCreateRequestDTO(String title, String description, TaskState state) {
    public TaskCreateRequestDTO(Task task){
        this(task.getTitle(), task.getDescription(), task.getState());
    }
}
