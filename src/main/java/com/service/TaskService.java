package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.model.Task;
import com.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task getTaskById(Long id) {
        if (id == null) {
            return null;
        }
        Optional<Task> taskOpt = repo.findById(id);
        return taskOpt.orElse(null);
    }

    public Task createTask(Task task) {
        if (task == null) {
            return null;
        }
        return repo.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        if (updatedTask == null) {
            return null;
        }
        updatedTask.setId(id);
        return repo.save(updatedTask);
    }

    public void deleteTask(Long id) {
        if (id != null) {
            Optional<Task> taskOptional = repo.findById(id);
            if (taskOptional.isPresent()) {
                repo.deleteById(id);
            } else {
                System.out.println("TaskService: deleteTask - Task with id " + id + " does not exist.");
            }
        } else {
            System.out.println("TaskService: deleteTask received null id");
            return;
        }
    }

}
