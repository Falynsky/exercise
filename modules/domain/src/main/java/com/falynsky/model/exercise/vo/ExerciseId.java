package com.falynsky.model.exercise.vo;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;


@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class ExerciseId  implements Serializable {
    private final UUID id;
}
