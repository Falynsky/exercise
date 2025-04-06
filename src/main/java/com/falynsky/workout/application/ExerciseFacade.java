package com.falynsky.workout.application;

import com.falynsky.workout.application.usecase.AddNewExerciseDTO;
import com.falynsky.workout.application.usecase.AddNewExerciseUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExerciseFacade {
    AddNewExerciseUseCase addNewExerciseUseCase;

    public boolean addNewExercise(AddNewExerciseDTO addNewExerciseDTO) {
        return addNewExerciseUseCase.addNewExercise(addNewExerciseDTO);
    }
}
