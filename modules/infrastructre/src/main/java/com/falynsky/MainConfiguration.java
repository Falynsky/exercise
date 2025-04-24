package com.falynsky;


import com.falynsky.exercise.ExerciseRepository;
import com.falynsky.mapper.ExerciseMapper;
import com.falynsky.mapper.ExerciseMapperImpl;
import com.falynsky.out.jpa.ExerciseRepositoryAdapter;
import com.falynsky.out.jpa.exercise.ExerciseJpaRepository;
import com.falynsky.out.jpa.exercise.mapper.ExerciseJpaMapper;
import com.falynsky.out.jpa.exercise.mapper.ExerciseJpaMapperImpl;
import com.falynsky.usecase.AddNewExerciseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class MainConfiguration {

    private final ExerciseJpaRepository exerciseJpaRepository;

    @Bean
    public ExerciseMapper exerciseMapper() {
        return new ExerciseMapperImpl();
    }

    @Bean
    public ExerciseJpaMapper exerciseJpaMapper() {
        return new ExerciseJpaMapperImpl();
    }

    @Bean
    public AddNewExerciseUseCase addNewExerciseUseCase() {
        return new AddNewExerciseFacade(exerciseRepository(), exerciseMapper());
    }

    @Bean
    public ExerciseRepository exerciseRepository() {
        return new ExerciseRepositoryAdapter(exerciseJpaRepository, exerciseJpaMapper());
    }

}
