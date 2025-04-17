package com.falynsky;

import com.falynsky.model.Exercise;

import java.util.Optional;

public interface ExerciseRepository {

    boolean addNewExercise(Exercise exercise);

    Optional<Exercise> findByName(String name);
}
