package com.falynsky.dto;

import java.util.Set;
public record ExerciseDTO(
        String id,
        String name,
        String description,
        Set<String> muscleGroups,
        Set<String> equipments,
        String difficulty,
        String exerciseType,
        Boolean isActive
) {}
