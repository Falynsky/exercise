package com.falynsky.command;


import java.util.Set;

public record UpdateExerciseCommand(
        String id,
        String name,
        String description,
        Set<String> muscleGroups,
        Set<String> equipments,
        Set<String> type,
        String difficulty,
        String exerciseType
) {}
