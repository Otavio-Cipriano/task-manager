package com.example.task_manager.controllers;

import com.example.task_manager.DTO.DeleteTaskDTO;
import com.example.task_manager.DTO.TaskCreateRequestDTO;
import com.example.task_manager.DTO.TasksDTO;
import com.example.task_manager.domain.models.Task;
import com.example.task_manager.domain.models.TaskState;
import com.example.task_manager.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody @Valid TaskCreateRequestDTO body){
        Task newTask = new Task(body.title(), body.description(), body.state());
        Task created = taskService.create(newTask);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }
    @GetMapping ("{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        Task task = taskService.findById(id);
        System.out.println(task);
        return ResponseEntity.ok(task);
    }
    @GetMapping("status/{taskState}")
    public ResponseEntity<List<TasksDTO>> getTasksByStatus(@PathVariable TaskState taskState){
        List<TasksDTO> tasks = taskService.getTasksByState(taskState);
        return ResponseEntity.ok(tasks);
    }
    @GetMapping
    public ResponseEntity<List<TasksDTO>> getAllTasks(){
        List<TasksDTO> tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskCreateRequestDTO updatedTask){
        Task newTask =  new Task(updatedTask.title(), updatedTask.description(), updatedTask.state());
        Task updated = taskService.updateTask(id, newTask);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
        Task task = taskService.deleteById(id);
        return ResponseEntity.ok(task);
    }
}
