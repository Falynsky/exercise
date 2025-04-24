package com.falynsky.out.jpa.exercise;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExerciseJpaRepository extends JpaRepository<ExerciseJpa, UUID> {

    Optional<ExerciseJpa> findByName(String name);
}
