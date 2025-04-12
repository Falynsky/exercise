package com.falynsky.workout.application.usecase.deleteExercise;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteExerciseDTO {
    @NotEmpty
    Long id;

}
