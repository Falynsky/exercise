package com.falynsky.usecase;
import com.falynsky.exercise.validator.ValidDifficulty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Set;

public record AddNewExerciseRequest(
    @NotEmpty
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
) {}
