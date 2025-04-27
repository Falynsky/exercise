package com.falynsky.usecase;

import com.falynsky.dto.ExerciseDTO;

import java.util.Set;

public interface GetAllExercisesUseCase {

    Set<ExerciseDTO> getAllExercises();
}
