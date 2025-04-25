package com.falynsky.in.web;

import com.falynsky.usecase.*;
import jakarta.validation.Valid;
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
    private final GetExerciseByIdUseCase getExerciseByIdUseCase;
    private final UpdateExerciseUseCase updateExerciseUseCase;

    @PostMapping
    public ResponseEntity<String> addNewExercise(@Valid @RequestBody NewExerciseRequest newExerciseRequest) {
        final String id = addNewExerciseUseCase.addNewExercise(newExerciseRequest);
        return ResponseEntity.created(URI.create("exercise/"+id)).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateExercise(@PathVariable("id") String id, @Valid @RequestBody NewExerciseRequest newExerciseRequest) {
        updateExerciseUseCase.updateExercise(id, newExerciseRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public Set<ExerciseDTO> getAllExercises() {
        return getAllExercisesUseCase.getAllExercises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDTO> getExerciseById(@PathVariable("id") String id) {
        return ResponseEntity.ok(getExerciseByIdUseCase.getExerciseById(id));
    }
}
