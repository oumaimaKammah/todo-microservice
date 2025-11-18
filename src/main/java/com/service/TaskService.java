package com.service;

import java.util.List;

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
        return repo.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        if (task != null) {
            return repo.save(task);
        }
        System.out.println("TaskService: createTask received null task");
        return null;

    }

    public Task updateTask(Long id, Task updatedTask) {
        updatedTask.setId(id);
        return repo.save(updatedTask);
    }

    public void deleteTask(Long id) {
        if (id == null) {
            System.out.println("TaskService: deleteTask received null id");
            return;

        }
        repo.deleteById(id);
    }

}
