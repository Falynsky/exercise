package com.falynsky.workout.adapters.out.jpa;

import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpa;
import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpaRepository;
import com.falynsky.workout.application.ExerciseRepository;
import com.falynsky.workout.domain.Exercise;
import lombok.AllArgsConstructor;

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
}