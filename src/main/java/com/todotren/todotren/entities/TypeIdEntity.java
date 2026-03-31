package com.todotren.todotren.entities;


import com.todotren.todotren.models.TypeId;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "types_id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeIdEntity {

    @Id
    private Long type_id;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeId tipe;
}
