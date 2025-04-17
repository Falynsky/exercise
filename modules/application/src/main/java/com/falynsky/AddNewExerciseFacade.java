package com.falynsky;


import com.falynsky.model.Exercise;
import com.falynsky.model.ExerciseType;
import com.falynsky.model.MuscleGroup;
import com.falynsky.usecase.AddNewExerciseDTO;
import com.falynsky.usecase.AddNewExerciseUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddNewExerciseFacade implements AddNewExerciseUseCase {

    private final ExerciseRepository exerciseRepository;

    @Override
    public boolean addNewExercise(@Valid AddNewExerciseDTO addNewExerciseDTO) {
        Exercise exercise = new Exercise(
                addNewExerciseDTO.getName(),
                MuscleGroup.valueOf(addNewExerciseDTO.getMuscleGroup()),
                ExerciseType.valueOf(addNewExerciseDTO.getType())
        );
        return exerciseRepository.addNewExercise(exercise);
    }
}
