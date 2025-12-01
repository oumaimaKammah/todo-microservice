package com.service;

import com.model.Task;
import com.repository.TaskRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Service class for managing {@link Task} entities.
 * <p>
 * Provides methods for :
 * <ul>
 * <li>Retrieving all tasks</li>
 * <li>Retrieving a task by Id</li>
 * <li>Creating a new task</li>
 * <li>Updating an existing task</li>
 * <li>Deleting a task</li>
 * </ul>
 */

@Service
public class TaskService {
    /**
     * The repository handling data operations for {@link Task} entities.
     */
    private final TaskRepository repo;

    /**
     * Constructor injection for {@link TaskRepository}
     * 
     * @param repo the repository to be injected handling data operations for
     *             tasks
     */

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    /**
     * Retrieves all tasks.
     * 
     * @return a list of all {@link Task} entities
     */
    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    /**
     * Retrieves a task by its id.
     * 
     * @param id the id of the task to retrieve
     * @return the {@link Task} entity if found, otherwise null
     */

    public Task getTaskById(Long id) {
        if (id == null) {
            return null;
        }
        Optional<Task> taskOpt = repo.findById(id);
        return taskOpt.orElse(null);
    }

    /**
     * Creates a new task.
     * 
     * @param task the {@link Task} entity to create
     * @return the created {@link Task} entity
     */

    public Task createTask(Task task) {
        if (task == null) {
            return null;
        }
        return repo.save(task);
    }

    /**
     * Updates an existing task.
     * 
     * @param id          the id of the task to update
     * @param updatedTask the {@link Task} entity with updated information
     * @return the updated {@link Task} entity
     */
    public Task updateTask(Long id, Task updatedTask) {
        if (updatedTask == null) {
            return null;
        }
        updatedTask.setId(id);
        return repo.save(updatedTask);
    }

    /**
     * Deletes a task by its id.
     * 
     * @param id the id of the task to delete
     */
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
