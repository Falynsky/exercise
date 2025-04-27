package com.falynsky.model.exercise.validator;

import com.falynsky.model.exercise.enums.Difficulty;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class DifficultyValidator implements ConstraintValidator<ValidDifficulty, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        return Arrays.stream(Difficulty.values())
                .anyMatch(difficulty -> difficulty.name().equalsIgnoreCase(value));
    }
}
