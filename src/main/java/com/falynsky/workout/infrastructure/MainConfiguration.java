package com.falynsky.workout.infrastructure;

import com.falynsky.workout.adapters.out.jpa.ExerciseRepositoryAdapter;
import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpaRepository;
import com.falynsky.workout.application.AddNewExerciseFacade;
import com.falynsky.workout.application.GetExerciseFacade;
import com.falynsky.workout.application.usecase.GetExerciseUseCase;
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
    public AddNewExerciseUseCase addNewExerciseUseCase() {
        return new AddNewExerciseFacade(exerciseRepository());
    }

    @Bean
    public ExerciseRepository exerciseRepository() {
        return new ExerciseRepositoryAdapter(exerciseJpaRepository);
    }

    @Bean
    public GetExerciseUseCase getExerciseUseCase() {
        return new GetExerciseFacade(exerciseRepository());
    }
}
