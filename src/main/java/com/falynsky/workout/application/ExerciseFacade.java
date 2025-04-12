package com.falynsky.workout.application;

import com.falynsky.workout.application.usecase.addNewExercise.AddNewExerciseDTO;
import com.falynsky.workout.application.usecase.addNewExercise.AddNewExerciseUseCase;
import com.falynsky.workout.application.usecase.deleteExercise.DeleteExerciseDTO;
import com.falynsky.workout.application.usecase.deleteExercise.DeleteExerciseUseCase;
import com.falynsky.workout.application.usecase.getExercise.GetExerciseDTO;
import com.falynsky.workout.application.usecase.getExercise.GetExerciseUseCase;
import com.falynsky.workout.domain.ExerciseRepository;
import com.falynsky.workout.domain.model.Exercise;
import com.falynsky.workout.domain.model.ExerciseType;
import com.falynsky.workout.domain.model.MuscleGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class ExerciseFacade implements AddNewExerciseUseCase, GetExerciseUseCase, DeleteExerciseUseCase {

    private final ExerciseRepository exerciseRepository;

    @Override
    public Long addNewExercise(@Valid AddNewExerciseDTO addNewExerciseDTO) {
        Exercise exercise = new Exercise(
                addNewExerciseDTO.getName(),
                MuscleGroup.valueOf(addNewExerciseDTO.getMuscleGroup()),
                ExerciseType.valueOf(addNewExerciseDTO.getType())
        );
        return exerciseRepository.addNewExercise(exercise);
    }

    @Override
    public Optional<Exercise> getExerciseByName(GetExerciseDTO name) {
        return exerciseRepository.findByName(name.getName());
    }

    @Override
    public void deleteExercise(DeleteExerciseDTO deleteExerciseDTO) {
        exerciseRepository.delete(deleteExerciseDTO.getId());
    }
}
