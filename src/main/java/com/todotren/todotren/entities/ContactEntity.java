package com.todotren.todotren.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@Entity
	@Table(name = "contacts")
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public class ContactEntity {

	    @Id
	    private Long id;
	    @JoinColumn (name = "costumer_id")
	    @ManyToOne
	    private CostumerEntity costumer;
	    @JoinColumn (name = "contact_type_id")
	    @ManyToOne
	    private ContactTypeEntity contactType;
	    @Column
	    private String contact;
	}

