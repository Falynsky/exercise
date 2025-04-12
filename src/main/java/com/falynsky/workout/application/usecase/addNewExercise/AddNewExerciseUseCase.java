package com.falynsky.workout.application.usecase.addNewExercise;


import jakarta.validation.Valid;

public interface AddNewExerciseUseCase {

    Long addNewExercise(@Valid AddNewExerciseDTO addNewExerciseDTO);
}
