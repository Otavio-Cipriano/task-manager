package com.example.task_manager.domain.repositories;

import com.example.task_manager.domain.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
