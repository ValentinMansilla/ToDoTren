package com.todotren.todotren.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private Long id;

    private Costumer costumer;

    private ContactType contactType;

    private String contact;
}
