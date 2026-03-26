package com.todotren.todotren.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contacts_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactTypeEntity {

    @Id
    private Long contact_type_id;

    @Column
    private String contactType;
}
