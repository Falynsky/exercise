package com.falynsky.handler;

import com.falynsky.command.NewExerciseCommand;
import com.falynsky.command.UpdateExerciseCommand;
import com.falynsky.mapper.ExerciseMapper;
import com.falynsky.model.exercise.Exercise;
import com.falynsky.port.ExerciseRepository;
import com.falynsky.services.ExerciseModificationPolicy;
import com.falynsky.usecase.AddNewExerciseUseCase;
import com.falynsky.usecase.UpdateExerciseUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class ExerciseCommandHandler implements AddNewExerciseUseCase, UpdateExerciseUseCase {

    private final ExerciseModificationPolicy exerciseModificationPolicy;
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    @Override
    public String execute(@Valid NewExerciseCommand command) {
        final Exercise exercise = exerciseMapper.toModel(command);
        UUID uuid = exerciseRepository.save(exercise);
        return uuid.toString();
    }

    @Override
    public void execute(UpdateExerciseCommand command) {
        Exercise existedExercise = exerciseRepository.findById(UUID.fromString(command.id())).orElseThrow(() -> new IllegalArgumentException("Exercise not found"));

        exerciseModificationPolicy.validateActiveState(existedExercise);

        existedExercise.renameTo(command.name());
        existedExercise.changeDescription(command.description());
        existedExercise.changeMuscleGroups(command.muscleGroups());
        existedExercise.changeEquipments(command.equipments());
        existedExercise.changeDifficulty(command.difficulty());
        existedExercise.changeExerciseType(command.exerciseType());
        existedExercise.changeActiveStatus();

        exerciseRepository.update(existedExercise);
    }

}
