package com.falynsky.in.web.request;

import com.falynsky.model.exercise.validator.ValidDifficulty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record NewExerciseRequest(
        @NotBlank
        @Size(min = 3)
        String name,

        @NotEmpty
        @Size(min = 10, max = 256)
        String description,

        @NotEmpty
        Set<String> muscleGroups,

        @NotEmpty
        Set<String> equipments,

        @NotEmpty
        Set<String> type,

        @NotEmpty
        @ValidDifficulty
        String difficulty,

        @NotEmpty
        String exerciseType
) {
}
