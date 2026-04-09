package com.todotren.todotren.repositories;

import com.todotren.todotren.entities.TypeIdEntity;
import com.todotren.todotren.models.TypeId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeIdRepository extends JpaRepository<TypeIdEntity, Long> {


    Optional<TypeIdEntity> findBytipe(TypeId type);
}
