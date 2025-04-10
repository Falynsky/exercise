package com.falynsky.workout.application.usecase;


import com.falynsky.workout.domain.model.Exercise;

import java.util.Optional;

public interface GetExerciseUseCase {
    Optional<Exercise> getExerciseByName(GetExerciseDTO name);
}
