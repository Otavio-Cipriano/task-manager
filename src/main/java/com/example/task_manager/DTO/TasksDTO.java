package com.example.task_manager.DTO;

import com.example.task_manager.domain.models.Task;
import com.example.task_manager.domain.models.TaskState;
import com.example.task_manager.domain.models.Users;

import java.time.LocalDateTime;

public record TasksDTO(
        Long Id, String title, String description,
        TaskState state/*Long user */, LocalDateTime createdAt,
        LocalDateTime updatedAt) {
    public TasksDTO(Task task) {
        this(task.getId(), task.getTitle(), task.getDescription(),
                task.getState(), task.getCreatedAt(), task.getUpdatedAt());
    }
}
