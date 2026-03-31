package com.todotren.todotren.repositories;

import com.todotren.todotren.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

}
