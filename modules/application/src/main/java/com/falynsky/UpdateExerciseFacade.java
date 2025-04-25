package com.falynsky;

import com.falynsky.exercise.Exercise;
import com.falynsky.exercise.ExerciseRepository;
import com.falynsky.mapper.ExerciseMapper;
import com.falynsky.usecase.NewExerciseRequest;
import com.falynsky.usecase.UpdateExerciseUseCase;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class UpdateExerciseFacade implements UpdateExerciseUseCase {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    @Override
    public void updateExercise(String id, NewExerciseRequest newExerciseRequest) {
        final Exercise model = exerciseMapper.toModel(newExerciseRequest);
        exerciseRepository.updateExercise(UUID.fromString(id), model);
    }
}
