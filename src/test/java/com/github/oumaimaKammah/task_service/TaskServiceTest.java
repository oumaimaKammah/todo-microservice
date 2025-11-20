package com.github.oumaimaKammah.task_service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.model.Task;
import com.repository.TaskRepository;
import com.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test retourning all tasks if exist")
    public void testGetAllTasks() {
        List<Task> mockTasks = Arrays.asList(new Task(1L, "Task 1", "Go to gym", "Pending", 1L),
                new Task(2L, "Task 2", "Do homework", "Completed", 2L));
        when(taskRepository.findAll()).thenReturn(mockTasks);

        List<Task> tasks = taskService.getAllTasks();

        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Test getting task by id when id is null")
    public void testGetTaskById_NullId() {
        Task task = taskService.getTaskById(null);
        assertNull(task);
        verify(taskRepository, never()).findById(anyLong());
    }

    @Test
    @DisplayName("Test getting task by id when id is not null")
    public void testGetTaskById_NotNullId() {
        Task mockTask = new Task(1L, "Task 1", "Go to gym", "Pending", 1L);
        when(taskRepository.findById(1L)).thenReturn(Optional.of(mockTask));

        Task task = taskService.getTaskById(1L);
        assertEquals(mockTask, task);
        verify(taskRepository, times(1)).findById(1L);
    }

    @SuppressWarnings("null")
    @Test
    @DisplayName("Test creating task when task is null")
    public void testCreateTask_NullTask() {
        Task task = taskService.createTask(null);
        assertNull(task);
        verify(taskRepository, never()).save(any(Task.class));
    }

    @Test
    @DisplayName("Test creation task when task is not null")
    public void testCreationTask_NotNullTask() {
        Task mockTask = new Task(4L, "Catch flight", "Go to the airport", "Pending", 4L);
        when(taskRepository.save(mockTask)).thenReturn(mockTask);
        Task task = taskService.createTask(mockTask);
        assertEquals(mockTask, task);
        verify(taskRepository, times(1)).save(mockTask);
    }

    @Test
    @DisplayName("Test updating task")
    public void testUpdateTask() {
        Task mockUpdatedTask = new Task(null, "Updated Task", "Updated Description", "In Progress", 1L);
        Task mockSavedTask = new Task(1L, "Updated Task", "Updated Description", "In Progress", 1L);
        when(taskRepository.save(any(Task.class))).thenReturn(mockSavedTask);
        Task updatedTask = taskService.updateTask(1L, mockUpdatedTask);
        assertEquals(mockSavedTask, updatedTask);
        verify(taskRepository, times(1)).save(mockUpdatedTask);
    }

    @Test
    @DisplayName("Test deleting task when id is not null")
    public void testDeleteTask_ExistentId() {
        Task mockTask = new Task(2L, "Task 2", "Do homework", "Completed", 2L);
        when(taskRepository.findById(2L)).thenReturn(Optional.of(mockTask));
        taskService.deleteTask(2L);
        verify(taskRepository, times(1)).findById(2L);
        verify(taskRepository, times(1)).deleteById(2L);
    }

    @Test
    @DisplayName("Test deleting task that does not exist")
    public void testDeleteTask_NonExistentId() {
        when(taskRepository.findById(3L)).thenReturn(Optional.empty());

        taskService.deleteTask(3L);

        verify(taskRepository, times(1)).findById(3L);
        verify(taskRepository, never()).deleteById(3L);

    }

}