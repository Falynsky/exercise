package com.falynsky;


import com.falynsky.model.Exercise;
import com.falynsky.usecase.GetExerciseDTO;
import com.falynsky.usecase.GetExerciseUseCase;
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
