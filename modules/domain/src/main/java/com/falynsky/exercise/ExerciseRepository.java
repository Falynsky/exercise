package com.falynsky.exercise;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ExerciseRepository {

    UUID addNewExercise(Exercise exercise);

    Set<Exercise> getAllExercises();

    Optional<Exercise> getExerciseById(UUID id);

    void updateExercise(UUID id, Exercise exercise);
}
