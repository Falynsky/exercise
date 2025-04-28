package com.falynsky.in.web;

import com.falynsky.command.NewExerciseCommand;
import com.falynsky.command.UpdateExerciseCommand;
import com.falynsky.in.web.request.NewExerciseRequest;
import com.falynsky.in.web.request.UpdateExerciseRequest;
import com.falynsky.mapper.ExerciseCommandMapper;
import com.falynsky.usecase.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("exercise")
class ExerciseCommandController {

    private final ExerciseCommandMapper commandMapper;
    private final AddNewExerciseUseCase addNewExerciseUseCase;
    private final UpdateExerciseUseCase updateExerciseUseCase;

    public ExerciseCommandController(
            ExerciseCommandMapper commandMapper,
            @Qualifier("addNewExerciseUseCase") AddNewExerciseUseCase addNewExerciseUseCase,
            @Qualifier("updateExerciseUseCase") UpdateExerciseUseCase updateExerciseUseCase
    ) {
        this.commandMapper = commandMapper;
        this.addNewExerciseUseCase = addNewExerciseUseCase;
        this.updateExerciseUseCase = updateExerciseUseCase;
    }

    @PostMapping
    public ResponseEntity<String> addNewExercise(@Valid @RequestBody NewExerciseRequest newExerciseRequest) {
        NewExerciseCommand command = commandMapper.toCommand(newExerciseRequest);
        final String id = addNewExerciseUseCase.execute(command);
        return ResponseEntity.created(URI.create("exercise/" + id)).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateExercise(@PathVariable("id") String id, @Valid @RequestBody UpdateExerciseRequest updateExerciseRequest) {
        UpdateExerciseCommand command = commandMapper.toCommand(id, updateExerciseRequest);
        updateExerciseUseCase.execute(command);
        return ResponseEntity.noContent().build();
    }

}
