package com.falynsky.out.jpa;


import com.falynsky.ExerciseRepository;
import com.falynsky.model.Exercise;
import com.falynsky.model.ExerciseType;
import com.falynsky.model.MuscleGroup;
import com.falynsky.out.jpa.exercise.ExerciseJpa;
import com.falynsky.out.jpa.exercise.ExerciseJpaRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class ExerciseRepositoryAdapter implements ExerciseRepository {

    private final ExerciseJpaRepository exerciseJpaRepository;

    @Override
    public boolean addNewExercise(Exercise exercise) {
        ExerciseJpa exerciseJpa = new ExerciseJpa(
                exercise.name(),
                exercise.muscleGroup().name(),
                exercise.type().name()
        );
        exerciseJpaRepository.save(exerciseJpa);
        return true;
    }

    @Override
    public Optional<Exercise> findByName(String name) {
        return exerciseJpaRepository.findByName(name)
                .map(exerciseJpa -> new Exercise(
                        exerciseJpa.getName(),
                        MuscleGroup.valueOf(exerciseJpa.getMuscleGroup()),
                        ExerciseType.valueOf(exerciseJpa.getType())
                ));
    }
}
