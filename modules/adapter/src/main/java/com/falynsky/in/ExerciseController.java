package com.falynsky.in;


import com.falynsky.model.Exercise;
import com.falynsky.usecase.AddNewExerciseDTO;
import com.falynsky.usecase.AddNewExerciseUseCase;
import com.falynsky.usecase.GetExerciseDTO;
import com.falynsky.usecase.GetExerciseUseCase;
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
