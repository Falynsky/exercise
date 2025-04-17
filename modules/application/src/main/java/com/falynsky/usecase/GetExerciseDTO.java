package com.falynsky.usecase;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetExerciseDTO {
    @NotEmpty
    @Size(min = 3, message = "Name must be at least 3 characters long")
    String name;

}
