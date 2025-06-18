package com.todotren.todotren.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private String name;
    private String desc;
    private LocalDateTime dateTime;
    private Importance importance;
    private State state;

}
