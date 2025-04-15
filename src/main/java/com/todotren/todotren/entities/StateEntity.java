package com.todotren.todotren.entities;

import com.todotren.todotren.models.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "task_states")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateEntity {

    @Id
    private Long state_id;

    @Column
    @Enumerated(EnumType.STRING)
    private State state;

}
