package com.falynsky;


import com.falynsky.out.jpa.ExerciseRepositoryAdapter;
import com.falynsky.out.jpa.exercise.ExerciseJpaRepository;
import com.falynsky.usecase.AddNewExerciseUseCase;
import com.falynsky.usecase.GetExerciseUseCase;
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
