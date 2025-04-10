package com.falynsky.workout.application;

import com.falynsky.workout.application.usecase.GetExerciseDTO;
import com.falynsky.workout.application.usecase.GetExerciseUseCase;
import com.falynsky.workout.domain.ExerciseRepository;
import com.falynsky.workout.domain.model.Exercise;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class GetExerciseFacade implements GetExerciseUseCase {

    private final ExerciseRepository exerciseRepository;

    @Override
    public Optional<Exercise> getExerciseByName(GetExerciseDTO name) {
        return exerciseRepository.findByName(name.getName());
    }
}
