package com.falynsky.workout.domain;

import com.falynsky.workout.domain.model.Exercise;

public interface ExerciseRepository {

    boolean addNewExercise(Exercise exercise);
}
