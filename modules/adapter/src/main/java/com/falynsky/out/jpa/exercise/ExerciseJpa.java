package com.falynsky.out.jpa.exercise;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercise")
@Getter
@NoArgsConstructor
public class ExerciseJpa {

    public ExerciseJpa(String name, String muscleGroup, String type) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String muscleGroup;

    @Column(nullable = false)
    private String type;

}
