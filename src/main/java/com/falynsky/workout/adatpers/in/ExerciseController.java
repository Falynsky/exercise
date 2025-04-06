package com.falynsky.workout.adatpers.in;

import com.falynsky.workout.application.ExerciseFacade;
import com.falynsky.workout.application.usecase.AddNewExerciseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exercise")
public class ExerciseController {

    ExerciseFacade exerciseFacade;

    @PostMapping()
    public boolean addNewExercise(@RequestBody String exercise){
        AddNewExerciseDTO exerciseDTO = new AddNewExerciseDTO();
        exerciseDTO.setName(exercise);
        exerciseDTO.setMuscleGroup("CHEST");
        exerciseDTO.setType("AEROBIC");

        return exerciseFacade.addNewExercise(exerciseDTO);
    }
}
