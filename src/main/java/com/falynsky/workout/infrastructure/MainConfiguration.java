package com.falynsky.workout.infrastructure;

import com.falynsky.workout.adatpers.out.jpa.ExerciseRepositoryAdapter;
import com.falynsky.workout.adatpers.out.jpa.exercise.ExerciseJpaRepository;
import com.falynsky.workout.application.ExerciseFacade;
import com.falynsky.workout.application.ExerciseRepository;
import com.falynsky.workout.application.usecase.AddNewExerciseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class MainConfiguration {

    private final ExerciseJpaRepository exerciseJpaRepository;

    @Bean
    public ExerciseFacade exerciseFacade() {
        return new ExerciseFacade(addNewExerciseUseCase());
    }

    @Bean
    public AddNewExerciseUseCase addNewExerciseUseCase() {
        return new AddNewExerciseUseCase(exerciseRepository());
    }

    @Bean
    public ExerciseRepository exerciseRepository() {
        return new ExerciseRepositoryAdapter(exerciseJpaRepository);
    }


}
