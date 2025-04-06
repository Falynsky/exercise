package com.falynsky.workout.application.usecase;

import com.falynsky.workout.application.ExerciseRepository;
import com.falynsky.workout.domain.Exercise;
import com.falynsky.workout.domain.ExerciseType;
import com.falynsky.workout.domain.MuscleGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddNewExerciseUseCase {

    private final ExerciseRepository exerciseRepository;

    public boolean addNewExercise(@Valid AddNewExerciseDTO addNewExerciseDTO) {
        Exercise exercise = new Exercise(
                addNewExerciseDTO.getName(),
                MuscleGroup.valueOf(addNewExerciseDTO.getMuscleGroup()),
                ExerciseType.valueOf(addNewExerciseDTO.getType())
        );
        return exerciseRepository.addNewExercise(exercise);
    }
}
