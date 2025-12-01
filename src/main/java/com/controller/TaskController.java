package com.controller;

import com.model.Task;
import com.service.TaskService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for managing {@link Task} entities.
 * <p>
 * Provides endpoints for :
 * <ul>
 * <li>Retrieving all tasks</li>
 * <li>Retrieving a task by Id</li>
 * <li>Creating a new task</li>
 * <li>Updating an existing task</li>
 * <li>Deleting a task</li>
 * </ul>
 * 
 * Base endpoint: /tasks
 */

@RestController
@RequestMapping("/tasks")
public class TaskController {
    /**
     * The service handling the business logic for {@link Task} entities.
     */
    private final TaskService service;

    /**
     * Constructor injection for {@link TaskService}
     * 
     * @param service the service to be injected handling the business logic for
     *                tasks
     */
    public TaskController(TaskService service) {
        this.service = service;
    }

    /**
     * Retrieves all tasks.
     * 
     * @return a list of all {@link Task} entities
     */

    @GetMapping()
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    /**
     * Retrieves a task by its id.
     * 
     * @param id the id of the task to retrieve
     * @return the {@link Task} entity if found
     */

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    /**
     * Create a new task.
     * 
     * @param task the {@link task } entity to be created, validated with
     *             {@link Valid}
     * @return the created {@link Task}
     */

    @PostMapping()
    public Task createTask(@Valid @RequestBody Task task) {
        return service.createTask(task);
    }

    /**
     * Update an existing task.
     * 
     * @param id   the id of the task to be updated
     * @param task the {@link Task} entity with updated information, validated with
     *             {@link Valid}
     * @return the updated {@link Task}
     */
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @Valid @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    /**
     * Delete a task by its id.
     * 
     * @param id the id of the task to be deleted
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
