package com.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Entity representing a Task in the system.
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "task")
public class Task {
    /**
     * The unique identifier for the task.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    /**
     * The title of the task.
     */
    @NotBlank(message = "Le titre est obligatoire")
    @Size(min = 3, max = 100, message = "Le titre doit contenir entre 3 et 100 caractères")
    private String title;

    /**
     * The description of the task.
     */
    @Size(max = 500, message = "La description ne peut pas dépasser 500 caractères")
    private String description;

    /**
     * The status of the task.
     */
    @NotBlank(message = "Le statut est obligatoire")
    @Pattern(regexp = "Pending|In Progress|Completed", message = "Le statut doit être'Pending'|'In Progress'|'Completed'")
    @Column(nullable = false)
    private String status;
    /**
     * The identifier of the user associated with the task.
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;
}