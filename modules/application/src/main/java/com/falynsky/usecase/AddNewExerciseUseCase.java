package com.falynsky.usecase;


import jakarta.validation.Valid;

public interface AddNewExerciseUseCase {

    void addNewExercise(@Valid AddNewExerciseRequest addNewExerciseRequest);
}
