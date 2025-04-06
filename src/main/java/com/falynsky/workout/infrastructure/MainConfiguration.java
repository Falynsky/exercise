package com.falynsky.workout.infrastructure;

import com.falynsky.workout.adapters.out.jpa.ExerciseRepositoryAdapter;
import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpaRepository;
import com.falynsky.workout.application.ExerciseServiceFacade;
import com.falynsky.workout.domain.ExerciseRepository;
import com.falynsky.workout.application.usecase.AddNewExerciseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class MainConfiguration {

    private final ExerciseJpaRepository exerciseJpaRepository;

    @Bean
    public AddNewExerciseUseCase exerciseFacade() {
        return new ExerciseServiceFacade(exerciseRepository());
    }

    @Bean
    public ExerciseRepository exerciseRepository() {
        return new ExerciseRepositoryAdapter(exerciseJpaRepository);
    }

}
