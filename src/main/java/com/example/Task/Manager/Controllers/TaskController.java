package com.example.Task.Manager.Controllers;

import com.example.Task.Manager.Entities.Task;
import com.example.Task.Manager.Repositories.TaskRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository taskrepository;

    public TaskController(TaskRepository taskrepository) {
        this.taskrepository = taskrepository;
    }


    @PostMapping
    public Task createTask(@RequestBody Task task) {
        Task saved = taskrepository.save(task);
        return saved;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskrepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        Task task = taskrepository.findById(id).orElse(null);
        return ResponseEntity.ok(task);
    }
}