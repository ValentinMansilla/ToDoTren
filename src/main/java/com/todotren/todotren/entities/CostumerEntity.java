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
	@Table(name = "contacts_type")
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public class CostumerEntity {

	    @Id
	    private Long costumer_id;

	    @Column
	    private String name;
	    
	    @Column
	    private String surname;
	    
	    @Column String address;
	    
	    @JoinColumn (name = "type_id")
	    @ManyToOne
	    private TypeIdEntity idType;
	    
	    @Column
	    private Integer dni;
	    
	    
	}

