package com.example.task_manager.DTO;

import com.example.task_manager.domain.models.Task;
import com.example.task_manager.domain.models.TaskState;

import java.time.LocalDateTime;

public record TaskGetResponseDTO(Long id, String title, String description, TaskState state, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public TaskGetResponseDTO(Task task){
        this(task.getId(), task.getTitle(), task.getDescription(), task.getState(), task.getCreatedAt(), task.getUpdatedAt());
    }
}