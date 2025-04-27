package com.falynsky.usecase;


import com.falynsky.command.NewExerciseCommand;
import jakarta.validation.Valid;

public interface AddNewExerciseUseCase {

    String execute(@Valid NewExerciseCommand command);
}
