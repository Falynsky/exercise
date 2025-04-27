package com.falynsky.out.jpa;


import com.falynsky.model.exercise.vo.ExerciseId;
import com.falynsky.port.ExerciseRepository;
import com.falynsky.model.exercise.Exercise;
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
    public UUID save(Exercise exercise) {
        final ExerciseJpa exerciseJpa = exerciseJpaMapper.toJpa(exercise);
        final ExerciseJpa save = exerciseJpaRepository.save(exerciseJpa);
        return save.getId();
    }

    @Override
    public Set<Exercise> findAll() {
        return exerciseJpaRepository.findAll()
                .stream()
                .map(exerciseJpaMapper::toDomain)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Exercise> findById(UUID id) {
        return exerciseJpaRepository.findById(id)
                .map(exerciseJpaMapper::toDomain);
    }

    //todo: add Transactional annotation somewhere
    @Override
    public void update(Exercise exercise) {
        ExerciseId id = exercise.getId();
        UUID uuid = id.getId();
        final ExerciseJpa exerciseFound = exerciseJpaRepository.findById(uuid).orElseThrow(() -> new IllegalArgumentException("Exercise not found"));
        final ExerciseJpa jpa = exerciseJpaMapper.toJpa(exercise); //todo: probably this JPA object will be detached and hibernate wont like it, but i dont care rn.
        jpa.setId(exerciseFound.getId()); //todo: maybe after change ID it will be attached again in save()
        exerciseJpaRepository.save(jpa);
    }
}
