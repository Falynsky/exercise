package com.falynsky.in.web;

import com.falynsky.dto.ExerciseDTO;
import com.falynsky.query.GetExerciseQuery;
import com.falynsky.usecase.GetAllExercisesUseCase;
import com.falynsky.usecase.GetExerciseByIdUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("exercise")
public class ExerciseQueryController {

    private final GetAllExercisesUseCase getAllExercisesUseCase;
    private final GetExerciseByIdUseCase getExerciseByIdUseCase;

    public ExerciseQueryController(
            @Qualifier("getAllExercisesUseCase") GetAllExercisesUseCase getAllExercisesUseCase,
            @Qualifier("getExerciseByIdUseCase") GetExerciseByIdUseCase getExerciseByIdUseCase) {
        this.getAllExercisesUseCase = getAllExercisesUseCase;
        this.getExerciseByIdUseCase = getExerciseByIdUseCase;
    }

    @GetMapping
    public Set<ExerciseDTO> getAllExercises() {
        return getAllExercisesUseCase.getAllExercises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDTO> getExerciseById(@PathVariable("id") String id) {
        GetExerciseQuery query = new GetExerciseQuery(UUID.fromString(id));
        return ResponseEntity.ok(getExerciseByIdUseCase.getExerciseById(query));
    }
}
