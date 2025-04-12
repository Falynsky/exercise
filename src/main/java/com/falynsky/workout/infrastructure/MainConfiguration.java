package com.falynsky.workout.infrastructure;

import com.falynsky.workout.adapters.out.jpa.ExerciseRepositoryAdapter;
import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpaMapper;
import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpaMapperImpl;
import com.falynsky.workout.adapters.out.jpa.exercise.ExerciseJpaRepository;
import com.falynsky.workout.application.ExerciseFacade;
import com.falynsky.workout.application.usecase.deleteExercise.DeleteExerciseUseCase;
import com.falynsky.workout.application.usecase.getExercise.GetExerciseUseCase;
import com.falynsky.workout.domain.ExerciseRepository;
import com.falynsky.workout.application.usecase.addNewExercise.AddNewExerciseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class MainConfiguration {

    private final ExerciseJpaRepository exerciseJpaRepository;

    @Bean
    public AddNewExerciseUseCase addNewExerciseUseCase() {
        return new ExerciseFacade(exerciseRepository());
    }

    @Bean
    public GetExerciseUseCase getExerciseUseCase() {
        return new ExerciseFacade(exerciseRepository());
    }

    @Bean
    public DeleteExerciseUseCase deleteExerciseUseCase() {
        return new ExerciseFacade(exerciseRepository());
    }

    @Bean
    public ExerciseJpaMapper exerciseJpaMapper() {
        return new ExerciseJpaMapperImpl();
    }

    @Bean
    public ExerciseRepository exerciseRepository() {
        return new ExerciseRepositoryAdapter(
                exerciseJpaRepository,
                exerciseJpaMapper()
        );
    }

}
