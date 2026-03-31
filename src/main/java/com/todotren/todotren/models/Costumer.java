package com.todotren.todotren.models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Costumer {

    private Long costumerId;

    private String name;

    private String surname;
    
    private String address;

    private TypeId idType;

    private Integer dni;

}
