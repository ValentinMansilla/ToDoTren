package com.todotren.todotren.dtos;

import com.todotren.todotren.models.Importance;
import com.todotren.todotren.models.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String desc;
    private LocalDateTime dateTime;
    @NotNull
    private Importance importance;
    private State state;
}
