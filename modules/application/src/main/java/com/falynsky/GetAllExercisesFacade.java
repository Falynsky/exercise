package com.falynsky;

import com.falynsky.exercise.Exercise;
import com.falynsky.exercise.ExerciseRepository;
import com.falynsky.mapper.ExerciseDTOMapper;
import com.falynsky.usecase.ExerciseDTO;
import com.falynsky.usecase.GetAllExercisesUseCase;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GetAllExercisesFacade implements GetAllExercisesUseCase {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseDTOMapper exerciseDTOMapper;

    @Override
    public Set<ExerciseDTO> getAllExercises() {
        final Set<Exercise> allExercises = exerciseRepository.getAllExercises();
        return allExercises.stream()
                .map(exerciseDTOMapper::toDTO)
                .collect(Collectors.toSet());
    }
}
