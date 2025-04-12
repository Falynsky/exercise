package com.falynsky.workout.adapters.out.jpa.exercise;

import com.falynsky.workout.domain.model.Exercise;
import org.mapstruct.Mapper;

@Mapper
public interface ExerciseJpaMapper {

    ExerciseJpa toJpa(Exercise exerciseJpa);

    Exercise toDomain(ExerciseJpa exerciseJpa);

}
