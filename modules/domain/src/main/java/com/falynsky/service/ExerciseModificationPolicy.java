package com.falynsky.service;

import com.falynsky.model.exercise.Exercise;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExerciseModificationPolicy {

    public void validateActiveState(Exercise exercise){
        if (Boolean.FALSE.equals(exercise.getIsActive())){
            throw new IllegalStateException("Cannot change exercise if it is inactive");
        }
    }
}
