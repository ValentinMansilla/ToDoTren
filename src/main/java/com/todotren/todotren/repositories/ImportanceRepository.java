package com.todotren.todotren.repositories;

import com.todotren.todotren.entities.ImportanceEntity;
import com.todotren.todotren.models.Importance;
import com.todotren.todotren.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImportanceRepository extends JpaRepository<ImportanceEntity, Long> {


    Optional<ImportanceEntity> findByImportance(Importance importance);
}
