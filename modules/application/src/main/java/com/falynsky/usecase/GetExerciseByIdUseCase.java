package com.falynsky.usecase;

import com.falynsky.dto.ExerciseDTO;
import com.falynsky.query.GetExerciseQuery;

public interface GetExerciseByIdUseCase {
    ExerciseDTO getExerciseById(GetExerciseQuery id);
}
