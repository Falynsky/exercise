package com.falynsky.in.web;

import com.falynsky.usecase.AddNewExerciseRequest;
import com.falynsky.usecase.AddNewExerciseUseCase;
import com.falynsky.usecase.ExerciseDTO;
import com.falynsky.usecase.GetAllExercisesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("exercise")
public class ExerciseController {

    private final AddNewExerciseUseCase addNewExerciseUseCase;
    private final GetAllExercisesUseCase getAllExercisesUseCase;

    @PostMapping
    public ResponseEntity<String> addNewExercise(@RequestBody AddNewExerciseRequest addNewExerciseRequest) {
        final String id = addNewExerciseUseCase.addNewExercise(addNewExerciseRequest);
        return ResponseEntity.created(URI.create("exercise/"+id)).body(id);
    }

    @GetMapping
    public Set<ExerciseDTO> getAllExercises() {
        return getAllExercisesUseCase.getAllExercises();
    }
}
