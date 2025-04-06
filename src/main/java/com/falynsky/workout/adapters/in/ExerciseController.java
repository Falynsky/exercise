package com.falynsky.workout.adapters.in;

import com.falynsky.workout.application.usecase.AddNewExerciseDTO;
import com.falynsky.workout.application.usecase.AddNewExerciseUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exercise")
public class ExerciseController {

    AddNewExerciseUseCase addNewExerciseUseCase;

    @PostMapping()
    public boolean addNewExercise(@RequestBody AddNewExerciseDTO exerciseDTO){
        return addNewExerciseUseCase.addNewExercise(exerciseDTO);
    }
}
