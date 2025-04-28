package com.falynsky.out.jpa.exercise.mapper;

import com.falynsky.model.exercise.*;
import com.falynsky.model.exercise.enums.Equipment;
import com.falynsky.model.exercise.enums.MuscleGroup;
import com.falynsky.model.exercise.vo.ExerciseDescription;
import com.falynsky.model.exercise.vo.ExerciseName;
import com.falynsky.out.jpa.exercise.ExerciseJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface ExerciseJpaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name.value")
    @Mapping(target = "description", source = "description.value")
    @Mapping(target = "muscleGroups", source = "muscleGroups", qualifiedByName = "muscleGroupsToString")
    @Mapping(target = "equipments", source = "equipments", qualifiedByName = "equipmentsToString")
    ExerciseJpa toJpa(Exercise exercise);

    @Mapping(target = "muscleGroups", source = "muscleGroups", qualifiedByName = "stringToMuscleGroups")
    @Mapping(target = "equipments", source = "equipments", qualifiedByName = "stringToEquipments")
    Exercise toDomain(ExerciseJpa exerciseJpa);

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

    @Named("stringToMuscleGroups")
    static Set<MuscleGroup> stringToMuscleGroups(String muscleGroups) {
        return Set.of(muscleGroups.split(",")).stream()
                .map(MuscleGroup::valueOf)
                .collect(Collectors.toSet());
    }

    @Named("stringToEquipments")
    static Set<Equipment> stringToEquipments(String equipments) {
        return Set.of(equipments.split(",")).stream()
                .map(Equipment::valueOf)
                .collect(Collectors.toSet());
    }
}
