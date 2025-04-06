package com.falynsky.workout.application;

import com.falynsky.workout.domain.Exercise;

public interface ExerciseRepository {

    boolean addNewExercise(Exercise exercise);
}
