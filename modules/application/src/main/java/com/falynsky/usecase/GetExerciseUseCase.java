package com.falynsky.usecase;


import com.falynsky.model.Exercise;

import java.util.Optional;

public interface GetExerciseUseCase {
    Optional<Exercise> getExerciseByName(GetExerciseDTO name);
}
