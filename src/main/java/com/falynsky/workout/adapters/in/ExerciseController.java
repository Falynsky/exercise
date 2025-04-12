package com.falynsky.workout.adapters.in;

import com.falynsky.workout.application.usecase.addNewExercise.AddNewExerciseDTO;
import com.falynsky.workout.application.usecase.addNewExercise.AddNewExerciseUseCase;
import com.falynsky.workout.application.usecase.deleteExercise.DeleteExerciseDTO;
import com.falynsky.workout.application.usecase.deleteExercise.DeleteExerciseUseCase;
import com.falynsky.workout.application.usecase.getExercise.GetExerciseDTO;
import com.falynsky.workout.application.usecase.getExercise.GetExerciseUseCase;
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
    private final DeleteExerciseUseCase deleteExerciseUseCase;

    @PostMapping
    public Long addNewExercise(@RequestBody AddNewExerciseDTO exerciseDTO) {
        return addNewExerciseUseCase.addNewExercise(exerciseDTO);
    }

    @GetMapping
    public Exercise getExercise(@RequestBody GetExerciseDTO exerciseDTO) {
        return getExerciseUseCase.getExerciseByName(exerciseDTO)
                .orElseThrow(NoSuchElementException::new);
    }

    @DeleteMapping
    public void deleteExercise(@RequestBody DeleteExerciseDTO deleteExerciseDTO) {
        deleteExerciseUseCase.deleteExercise(deleteExerciseDTO);
    }

}
