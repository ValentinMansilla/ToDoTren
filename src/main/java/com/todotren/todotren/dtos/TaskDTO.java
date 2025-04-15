package com.todotren.todotren.dtos;

import com.todotren.todotren.models.Importance;
import com.todotren.todotren.models.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    @NotNull
    private String name;
    @NotNull
    private String desc;
    @NotNull
    private Importance importance;
    @NotNull
    private State state;
}
