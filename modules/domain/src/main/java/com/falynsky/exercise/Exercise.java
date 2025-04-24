package com.falynsky.exercise;

import com.falynsky.event.DomainIncomingEvent;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@ToString
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Exercise {

    private ExerciseId id;
    private ExerciseName name;
    private ExerciseDescription description;
    private Set<MuscleGroup> muscleGroups;
    private Set<Equipment> equipments;
    private Difficulty difficulty;
    private ExerciseType exerciseType;
    private Boolean isActive;

    public Exercise(UUID id, String name, String description, Set<MuscleGroup> muscleGroups, Set<Equipment> equipments, Difficulty difficulty, ExerciseType exerciseType) {
        this.id = ExerciseId.of(id);
        this.name = ExerciseName.of(name);
        this.description = ExerciseDescription.of(description);
        this.muscleGroups = muscleGroups;
        this.equipments = equipments;
        this.difficulty = difficulty;
        this.exerciseType = exerciseType;
        this.isActive = Boolean.TRUE;
    }

    public void renameTo(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new RuntimeException("Name cannot be empty");
        }
        this.name = ExerciseName.of(newName);
    }

    public void changeDescription(ExerciseDescription newDescription) {
        if (newDescription == null ||  newDescription.getValue() == null || newDescription.getValue().isBlank()) {
            throw new RuntimeException("Description cannot be empty");
        }
        this.description = newDescription;
    }

    public void changeMuscleGroup(Set<MuscleGroup> muscleGroups) {
        this.muscleGroups.clear();
        this.muscleGroups.addAll(muscleGroups);
    }

    public void changeEquipment(Set<Equipment> equipments) {
        this.equipments.clear();
        this.equipments.addAll(equipments);
    }

    public void inactive() {
        this.isActive = false;
    }

    public void changeDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
