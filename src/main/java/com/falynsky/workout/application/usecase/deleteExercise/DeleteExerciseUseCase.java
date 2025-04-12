package com.falynsky.workout.application.usecase.deleteExercise;


import jakarta.validation.Valid;

public interface DeleteExerciseUseCase {

    void deleteExercise(@Valid DeleteExerciseDTO deleteExerciseDTO);
}
