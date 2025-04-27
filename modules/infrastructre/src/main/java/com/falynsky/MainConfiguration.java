package com.falynsky;


import com.falynsky.adapter.SpringTransactionalUnitOfWork;
import com.falynsky.domain.UnitOfWork;
import com.falynsky.handler.ExerciseCommandHandler;
import com.falynsky.handler.ExerciseQueryHandler;
import com.falynsky.mapper.*;
import com.falynsky.port.ExerciseRepository;
import com.falynsky.service.ExerciseModificationPolicy;
import com.falynsky.out.jpa.ExerciseRepositoryAdapter;
import com.falynsky.out.jpa.exercise.ExerciseJpaRepository;
import com.falynsky.out.jpa.exercise.mapper.ExerciseJpaMapper;
import com.falynsky.out.jpa.exercise.mapper.ExerciseJpaMapperImpl;
import com.falynsky.usecase.AddNewExerciseUseCase;
import com.falynsky.usecase.GetAllExercisesUseCase;
import com.falynsky.usecase.GetExerciseByIdUseCase;
import com.falynsky.usecase.UpdateExerciseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    public ExerciseDTOMapper exerciseDTOMapper() {
        return new ExerciseDTOMapperImpl();
    }

    @Bean
    public UnitOfWork unitOfWork(){
        return new SpringTransactionalUnitOfWork();
    }

    @Bean
    public ExerciseModificationPolicy exerciseService() {
        return new ExerciseModificationPolicy();
    }

    @Bean
    public ExerciseCommandHandler exerciseCommandHandler(
            ExerciseModificationPolicy exerciseModificationPolicy,
            ExerciseMapper exerciseMapper
    ) {
        return new ExerciseCommandHandler(exerciseModificationPolicy, exerciseRepository(), exerciseMapper);
    }

    @Primary
    @Bean
    public AddNewExerciseUseCase addNewExerciseUseCase(ExerciseCommandHandler handler) {
        return handler;
    }

    @Primary
    @Bean
    public UpdateExerciseUseCase updateExerciseUseCase(ExerciseCommandHandler handler) {
        return handler;
    }

    @Bean
    public ExerciseQueryHandler exerciseQueryHandler() {
        return new ExerciseQueryHandler(exerciseRepository(), exerciseDTOMapper(), unitOfWork());
    }

    @Primary
    @Bean
    public GetAllExercisesUseCase getAllExercisesUseCase(ExerciseQueryHandler handler) {
        return handler;
    }

    @Primary
    @Bean
    public GetExerciseByIdUseCase getExerciseByIdUseCase(ExerciseQueryHandler handler) {
        return handler;
    }

    @Bean
    public ExerciseRepository exerciseRepository() {
        return new ExerciseRepositoryAdapter(exerciseJpaRepository, exerciseJpaMapper());
    }

    @Bean
    public ExerciseCommandMapper exerciseCommandMapper() {
        return new ExerciseCommandMapperImpl();
    }

}
