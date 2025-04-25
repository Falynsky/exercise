package com.falynsky.out.jpa;


import com.falynsky.exercise.ExerciseRepository;
import com.falynsky.exercise.Exercise;
import com.falynsky.exercise.ExerciseType;
import com.falynsky.exercise.MuscleGroup;
import com.falynsky.out.jpa.exercise.ExerciseJpa;
import com.falynsky.out.jpa.exercise.ExerciseJpaRepository;
import com.falynsky.out.jpa.exercise.mapper.ExerciseJpaMapper;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ExerciseRepositoryAdapter implements ExerciseRepository {

    private final ExerciseJpaRepository exerciseJpaRepository;
    private final ExerciseJpaMapper exerciseJpaMapper;

    @Override
    public UUID addNewExercise(Exercise exercise) {
        final ExerciseJpa exerciseJpa = exerciseJpaMapper.toJpa(exercise);
        final ExerciseJpa save = exerciseJpaRepository.save(exerciseJpa);
        return save.getId();
    }

    @Override
    public Set<Exercise> getAllExercises() {
        return exerciseJpaRepository.findAll()
                .stream()
                .map(exerciseJpaMapper::toDomain)
                .collect(Collectors.toSet());
    }
}
