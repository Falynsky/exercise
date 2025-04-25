package com.falynsky;


import com.falynsky.exercise.*;
import com.falynsky.mapper.ExerciseMapper;
import com.falynsky.usecase.NewExerciseRequest;
import com.falynsky.usecase.AddNewExerciseUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
class AddNewExerciseFacade implements AddNewExerciseUseCase {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    @Override
    public String addNewExercise(@Valid NewExerciseRequest newExerciseRequest) {
        final Exercise exercise = exerciseMapper.toModel(newExerciseRequest);
        final UUID uuid = exerciseRepository.addNewExercise(exercise);
        return  uuid.toString();
    }
}
