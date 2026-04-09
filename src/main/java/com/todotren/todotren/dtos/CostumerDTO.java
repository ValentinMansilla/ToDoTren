package com.todotren.todotren.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.todotren.todotren.models.TypeId;

import jakarta.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostumerDTO {
    
	private String name;

    @NotNull
    private String surname;
    
    private String address;

    @NotNull
    private TypeId idType;
    @NotNull
    private Integer dni;
}
