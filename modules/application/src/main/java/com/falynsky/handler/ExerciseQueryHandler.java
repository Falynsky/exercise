package com.falynsky.handler;

import com.falynsky.dto.ExerciseDTO;
import com.falynsky.mapper.ExerciseDTOMapper;
import com.falynsky.model.exercise.Exercise;
import com.falynsky.port.ExerciseRepository;
import com.falynsky.query.GetExerciseQuery;
import com.falynsky.usecase.*;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ExerciseQueryHandler implements GetAllExercisesUseCase, GetExerciseByIdUseCase {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseDTOMapper exerciseDTOMapper;

    @Override
    public Set<ExerciseDTO> getAllExercises() {
        final Set<Exercise> allExercises = exerciseRepository.findAll();
        return allExercises.stream()
                .map(exerciseDTOMapper::toDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public ExerciseDTO getExerciseById(GetExerciseQuery query) {
        return exerciseRepository.findById(query.uuid())
                .map(exerciseDTOMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Exercise not found"));
    }

}
