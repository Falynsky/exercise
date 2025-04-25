package com.falynsky;

import com.falynsky.exercise.ExerciseRepository;
import com.falynsky.mapper.ExerciseDTOMapper;
import com.falynsky.usecase.ExerciseDTO;
import com.falynsky.usecase.GetExerciseByIdUseCase;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class GetExerciseByIdFacade implements GetExerciseByIdUseCase {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseDTOMapper exerciseDTOMapper;


    @Override
    public ExerciseDTO getExerciseById(String id) {
        return exerciseRepository.getExerciseById(UUID.fromString(id))
                .map(exerciseDTOMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Exercise not found"));
    }
}
