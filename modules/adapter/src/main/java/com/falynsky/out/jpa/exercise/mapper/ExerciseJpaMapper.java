package com.falynsky.out.jpa.exercise.mapper;

import com.falynsky.exercise.*;
import com.falynsky.out.jpa.exercise.ExerciseJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface ExerciseJpaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name", qualifiedByName = "exerciseNameToName")
    @Mapping(target = "description", source = "description", qualifiedByName = "exerciseDescriptionToDescription")
    @Mapping(target = "muscleGroups", source = "muscleGroups", qualifiedByName = "muscleGroupsToString")
    @Mapping(target = "equipments", source = "equipments", qualifiedByName = "equipmentsToString")
    ExerciseJpa toJpa(Exercise exercise);

    @Named("exerciseNameToName")
    static String exerciseNameToName(ExerciseName name) {
        return name.getValue();
    }

    @Named("exerciseDescriptionToDescription")
    static String exerciseDescriptionToDescription(ExerciseDescription description) {
        return description.getValue();
    }

    @Named("muscleGroupsToString")
    static String muscleGroupsToString(Set<MuscleGroup> muscleGroups) {
        return muscleGroups.stream()
                .map(MuscleGroup::name)
                .collect(Collectors.joining(","));
    }

    @Named("equipmentsToString")
    static String equipmentsToString(Set<Equipment> equipments) {
        return equipments.stream()
                .map(Equipment::name)
                .collect(Collectors.joining(","));
    }
}
