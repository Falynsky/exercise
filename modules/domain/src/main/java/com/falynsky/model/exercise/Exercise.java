package com.falynsky.model.exercise;

import com.falynsky.model.exercise.enums.Difficulty;
import com.falynsky.model.exercise.enums.Equipment;
import com.falynsky.model.exercise.enums.ExerciseType;
import com.falynsky.model.exercise.enums.MuscleGroup;
import com.falynsky.model.exercise.vo.ExerciseDescription;
import com.falynsky.model.exercise.vo.ExerciseId;
import com.falynsky.model.exercise.vo.ExerciseName;
import lombok.*;

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

    public void changeDescription(String newDescription) {
        if (newDescription == null  || newDescription.isBlank()) {
            throw new RuntimeException("Description cannot be empty");
        }
        this.description = ExerciseDescription.of(newDescription);
    }

    public void changeMuscleGroups(Set<String> muscleGroups) {
        this.muscleGroups.clear();
        muscleGroups.stream()
                .map(MuscleGroup::valueOf)
                .forEach(this.muscleGroups::add);
    }

    public void changeEquipments(Set<String> equipments) {
        this.equipments.clear();
        equipments.stream()
                .map(Equipment::valueOf)
                .forEach(this.equipments::add);
    }

    public void changeDifficulty(String difficulty) {
        this.difficulty = Difficulty.valueOf(difficulty);
    }

    public void changeExerciseType(String exerciseType) {
        this.exerciseType = ExerciseType.valueOf(exerciseType);
    }

    public void changeActiveStatus() {
        this.isActive = !this.isActive;
    }
}
