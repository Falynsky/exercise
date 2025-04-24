package com.falynsky.out.jpa.exercise;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "exercise")
@Getter
@Setter
@NoArgsConstructor
public class ExerciseJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String muscleGroups;

    @Column(nullable = false)
    private String equipments;

    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false)
    private String exerciseType;

    @Column(nullable = false)
    Boolean isActive;
}
