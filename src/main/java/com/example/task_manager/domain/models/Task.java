package com.example.task_manager.domain.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "tb_tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskState state = TaskState.TODO;

//    @ManyToOne
//    @JoinColumn(name = "users_id", nullable = false)
//    private Users user;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Task(String title, String description, TaskState state) {
        this.title = title;
        this.description = description;
        this.state = state;
    }

    public Task() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

//    public Long getUser(){
//        return user.getId();
//    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
