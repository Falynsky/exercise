package com.falynsky.workout.adapters.out.jpa.exercise;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseJpaRepository extends JpaRepository<ExerciseJpa, Long> {

    Optional<ExerciseJpa> findByName(String name);
}
