package com.falynsky.exercise;

import java.util.Set;
import java.util.UUID;

public interface ExerciseRepository {

    UUID addNewExercise(Exercise exercise);

    Set<Exercise> getAllExercises();

}
