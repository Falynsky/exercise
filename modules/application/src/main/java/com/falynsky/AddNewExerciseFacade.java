package com.falynsky;


import com.falynsky.exercise.*;
import com.falynsky.mapper.ExerciseMapper;
import com.falynsky.usecase.AddNewExerciseRequest;
import com.falynsky.usecase.AddNewExerciseUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
class AddNewExerciseFacade implements AddNewExerciseUseCase {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    @Override
    public String addNewExercise(@Valid AddNewExerciseRequest addNewExerciseRequest) {
        final Exercise exercise = exerciseMapper.toModel(addNewExerciseRequest);
        final UUID uuid = exerciseRepository.addNewExercise(exercise);
        return  uuid.toString();
    }
}
