package com.example.task_manager.domain.repositories;

import com.example.task_manager.DTO.TasksDTO;
import com.example.task_manager.domain.models.Task;
import com.example.task_manager.domain.models.TaskState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<TasksDTO> findByState(TaskState state);
}
