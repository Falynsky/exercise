package com.falynsky.port;

import com.falynsky.model.exercise.Exercise;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ExerciseRepository {

    UUID save(Exercise exercise);

    Set<Exercise> findAll();

    Optional<Exercise> findById(UUID id);

    void update(Exercise exercise);
}
