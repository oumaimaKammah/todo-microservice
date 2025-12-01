package com.repository;

import com.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Task} entities.
 * <p>
 * Extends {@link JpaRepository} to provide CRUD operations and
 * additional JPA functionalities for Task entities.
 */

public interface TaskRepository extends JpaRepository<Task, Long> {

}
