package com.falynsky.in;


import com.falynsky.usecase.AddNewExerciseRequest;
import com.falynsky.usecase.AddNewExerciseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("exercise")
public class ExerciseController {

    private final AddNewExerciseUseCase addNewExerciseUseCase;

    @PostMapping
    public void addNewExercise(@RequestBody AddNewExerciseRequest addNewExerciseRequest) {
        addNewExerciseUseCase.addNewExercise(addNewExerciseRequest);
    }


}
