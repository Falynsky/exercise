package com.falynsky.usecase;


import jakarta.validation.Valid;

public interface AddNewExerciseUseCase {

    String addNewExercise(@Valid AddNewExerciseRequest addNewExerciseRequest);
}
