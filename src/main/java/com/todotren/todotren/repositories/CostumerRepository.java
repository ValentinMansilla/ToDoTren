package com.todotren.todotren.repositories;

import com.todotren.todotren.entities.CostumerEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CostumerRepository extends JpaRepository<CostumerEntity, Long> {
	Optional<CostumerEntity> findByName(String name);
	Optional<CostumerEntity> findByDNI(Integer dni);
	boolean existsByDNI(Integer dni);
}
