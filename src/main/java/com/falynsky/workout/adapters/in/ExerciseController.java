package com.falynsky.workout.adapters.in;

import com.falynsky.workout.application.usecase.AddNewExerciseDTO;
import com.falynsky.workout.application.usecase.AddNewExerciseUseCase;
import com.falynsky.workout.application.usecase.GetExerciseDTO;
import com.falynsky.workout.application.usecase.GetExerciseUseCase;
import com.falynsky.workout.domain.model.Exercise;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("exercise")
public class ExerciseController {

   private final AddNewExerciseUseCase addNewExerciseUseCase;
   private final GetExerciseUseCase getExerciseUseCase;

    @PostMapping()
    public boolean addNewExercise(@RequestBody AddNewExerciseDTO exerciseDTO){
        return addNewExerciseUseCase.addNewExercise(exerciseDTO);
    }

    @GetMapping()
    public Exercise addNewExercise(@RequestBody GetExerciseDTO exerciseDTO){
        return getExerciseUseCase.getExerciseByName(exerciseDTO).orElseThrow(NoSuchElementException::new);
    }
}
