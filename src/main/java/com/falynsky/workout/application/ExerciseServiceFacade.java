package com.falynsky.workout.application;

import com.falynsky.workout.application.usecase.AddNewExerciseDTO;
import com.falynsky.workout.application.usecase.AddNewExerciseUseCase;
import com.falynsky.workout.domain.ExerciseRepository;
import com.falynsky.workout.domain.model.Exercise;
import com.falynsky.workout.domain.model.ExerciseType;
import com.falynsky.workout.domain.model.MuscleGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExerciseServiceFacade implements AddNewExerciseUseCase {

    private final ExerciseRepository exerciseRepository;

    @Override
    public boolean addNewExercise(@Valid AddNewExerciseDTO addNewExerciseDTO) {
        Exercise exercise = new Exercise(
                addNewExerciseDTO.getName(),
                MuscleGroup.valueOf(addNewExerciseDTO.getMuscleGroup()),
                ExerciseType.valueOf(addNewExerciseDTO.getType())
        );
        return exerciseRepository.addNewExercise(exercise);
    }
}