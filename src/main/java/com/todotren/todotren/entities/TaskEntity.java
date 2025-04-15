package com.todotren.todotren.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String desc;

    private LocalDateTime dateTime;

    @JoinColumn (name = "state_id")
    @ManyToOne
    private StateEntity state;

    @JoinColumn (name = "importance_id")
    @ManyToOne
    private ImportanceEntity importance;
}
