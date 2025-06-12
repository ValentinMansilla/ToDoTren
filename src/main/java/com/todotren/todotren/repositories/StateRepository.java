package com.todotren.todotren.repositories;

import com.todotren.todotren.entities.StateEntity;
import com.todotren.todotren.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Long> {

    Optional<StateEntity> findByState(State state);
}
