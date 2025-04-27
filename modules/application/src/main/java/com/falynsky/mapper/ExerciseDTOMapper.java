package com.falynsky.mapper;

import com.falynsky.model.exercise.*;
import com.falynsky.dto.ExerciseDTO;
import com.falynsky.model.exercise.enums.Equipment;
import com.falynsky.model.exercise.enums.MuscleGroup;
import com.falynsky.model.exercise.vo.ExerciseDescription;
import com.falynsky.model.exercise.vo.ExerciseId;
import com.falynsky.model.exercise.vo.ExerciseName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface ExerciseDTOMapper {

    @Mapping(target = "id", source = "id", qualifiedByName = "exerciseIdToId")
    @Mapping(target = "name", source = "name", qualifiedByName = "exerciseNameToName")
    @Mapping(target = "description", source = "description", qualifiedByName = "exerciseDescriptionToDescription")
    @Mapping(target = "muscleGroups", source = "muscleGroups", qualifiedByName = "muscleGroupsToString")
    @Mapping(target = "equipments", source = "equipments", qualifiedByName = "equipmentsToString")
    ExerciseDTO toDTO(Exercise exercise);

    @Named("exerciseIdToId")
    static String exerciseIdToId(ExerciseId id) {
        return id.getId().toString();
    }

    @Named("exerciseNameToName")
    static String exerciseNameToName(ExerciseName name) {
        return name.getValue();
    }

    @Named("exerciseDescriptionToDescription")
    static String exerciseDescriptionToDescription(ExerciseDescription description) {
        return description.getValue();
    }

    @Named("muscleGroupsToString")
    static Set<String> muscleGroupsToString(Set<MuscleGroup> muscleGroups) {
        return muscleGroups.stream()
                .map(MuscleGroup::name)
                .collect(Collectors.toSet());
    }

    @Named("equipmentsToString")
    static Set<String> equipmentsToString(Set<Equipment> equipments) {
        return equipments.stream()
                .map(Equipment::name)
                .collect(Collectors.toSet());
    }

}
