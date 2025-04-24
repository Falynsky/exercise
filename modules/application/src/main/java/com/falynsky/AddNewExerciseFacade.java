package com.falynsky;


import com.falynsky.exercise.*;
import com.falynsky.mapper.ExerciseMapper;
import com.falynsky.usecase.AddNewExerciseRequest;
import com.falynsky.usecase.AddNewExerciseUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class AddNewExerciseFacade implements AddNewExerciseUseCase {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    @Override
    public void addNewExercise(@Valid AddNewExerciseRequest addNewExerciseRequest) {
        final Exercise exercise = exerciseMapper.toModel(addNewExerciseRequest);
        exerciseRepository.addNewExercise(exercise);
    }
}
