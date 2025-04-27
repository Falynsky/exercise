package com.falynsky.mapper;

import com.falynsky.command.NewExerciseCommand;
import com.falynsky.command.UpdateExerciseCommand;
import com.falynsky.model.exercise.enums.Equipment;
import com.falynsky.model.exercise.Exercise;
import com.falynsky.model.exercise.enums.MuscleGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper
public interface ExerciseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "muscleGroups", source = "muscleGroups", qualifiedByName = "muscleGroupsFromString")
    @Mapping(target = "equipments", source = "equipments", qualifiedByName = "equipmentsFromString")
    Exercise toModel(NewExerciseCommand command);

    @Mapping(target = "id", source = "id", qualifiedByName = "UUIDFromString")
    @Mapping(target = "muscleGroups", source = "muscleGroups", qualifiedByName = "muscleGroupsFromString")
    @Mapping(target = "equipments", source = "equipments", qualifiedByName = "equipmentsFromString")
    Exercise toModel(UpdateExerciseCommand command);

    @Named("UUIDFromString")
    static UUID UUIDFromString(String id) {
        return UUID.fromString(id);
    }

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
