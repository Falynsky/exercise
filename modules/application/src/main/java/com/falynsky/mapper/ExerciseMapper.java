package com.falynsky.mapper;

import com.falynsky.exercise.Equipment;
import com.falynsky.exercise.Exercise;
import com.falynsky.exercise.MuscleGroup;
import com.falynsky.usecase.NewExerciseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface ExerciseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "muscleGroups", source = "muscleGroups", qualifiedByName = "muscleGroupsFromString")
    @Mapping(target = "equipments", source = "equipments", qualifiedByName = "equipmentsFromString")
    Exercise toModel(NewExerciseRequest newExerciseRequest);

    @Named("muscleGroupsFromString")
    static Set<MuscleGroup> muscleGroupsFromString(Set<String> muscleGroups) {
        return muscleGroups.stream()
                .map(MuscleGroup::valueOf)
                .collect(Collectors.toSet());
    }

    @Named("equipmentsFromString")
    static Set<Equipment> equipmentsFromString(Set<String> equipments) {
        return equipments.stream()
                .map(Equipment::valueOf)
                .collect(Collectors.toSet());
    }
}
