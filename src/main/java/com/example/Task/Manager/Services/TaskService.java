package com.example.Task.Manager.Services;

import com.example.Task.Manager.Entities.Task;
import com.example.Task.Manager.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task createTask(Task task) {
        if (task.getTitle()==null || task.getDescription()==null) {
            throw new IllegalArgumentException("Title and description are required");
        }
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(Long Id, Task updatedTask) {
        return (taskRepository.findById(Id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setTaskPriority(updatedTask.getTaskPriority());
            task.setTaskStatus(updatedTask.getTaskStatus());
            return taskRepository.save(task);
        }));
    }

    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public boolean deleteTask(Long id) {
        if (taskRepository.findById(id).isPresent()) {
        taskRepository.deleteById(id);
        return true;
        }
        return false;
    }


}
