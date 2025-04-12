package com.falynsky.workout.adapters.out.jpa;

import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpa;
import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpaMapper;
import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpaRepository;
import com.falynsky.workout.domain.ExerciseRepository;
import com.falynsky.workout.domain.model.Exercise;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class ExerciseRepositoryAdapter implements ExerciseRepository {

    private final ExerciseJpaRepository exerciseJpaRepository;
    private final ExerciseJpaMapper mapper;

    @Override
    public Long addNewExercise(Exercise exercise) {
        Optional<ExerciseJpa> foundExercise = exerciseJpaRepository.findByName(exercise.name());

        if (foundExercise.isPresent()) {
            ExerciseJpa exerciseJpa = foundExercise.get();
            return exerciseJpa.getId();
        }

        ExerciseJpa exerciseJpa = mapper.toJpa(exercise);
        ExerciseJpa exercies = exerciseJpaRepository.save(exerciseJpa);

        return exercies.getId();
    }

    @Override
    public Optional<Exercise> findByName(String name) {
        return exerciseJpaRepository.findByName(name)
                .map(mapper::toDomain);
    }

    @Override
    public void delete(Long id) {
        ExerciseJpa exerciseJpa = exerciseJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exercise with id " + id + " not found"));
        exerciseJpaRepository.delete(exerciseJpa);
    }

}
