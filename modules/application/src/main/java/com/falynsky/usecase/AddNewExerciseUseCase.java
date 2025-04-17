package com.falynsky.usecase;


import jakarta.validation.Valid;

public interface AddNewExerciseUseCase {

    boolean addNewExercise(@Valid AddNewExerciseDTO addNewExerciseDTO);
}
