package com.falynsky.workout.domain;

import com.falynsky.workout.domain.model.Exercise;

import java.util.Optional;

public interface ExerciseRepository {

    boolean addNewExercise(Exercise exercise);

    Optional<Exercise> findByName(String name);
}
