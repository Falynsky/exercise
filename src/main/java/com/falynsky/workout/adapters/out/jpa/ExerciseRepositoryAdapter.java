package com.falynsky.workout.adapters.out.jpa;

import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpa;
import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpaRepository;
import com.falynsky.workout.domain.ExerciseRepository;
import com.falynsky.workout.domain.model.Exercise;
import com.falynsky.workout.domain.model.ExerciseType;
import com.falynsky.workout.domain.model.MuscleGroup;
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
