package com.todotren.todotren.entities;

import com.todotren.todotren.models.Importance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "task_importances")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImportanceEntity {

    @Id
    private Long importance_id;

    @Column
    @Enumerated(EnumType.STRING)
    private Importance importance;
}
