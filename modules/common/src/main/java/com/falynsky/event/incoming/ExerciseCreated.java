//package com.falynsky.exercise.event.incoming;
//
//import com.falynsky.event.DomainIncomingEvent;
//import com.falynsky.exercise.*;
//import lombok.*;
//
//import java.util.Set;
//import java.util.UUID;
//
//@Value
//@Builder
//@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
//@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
//public class ExerciseCreated implements DomainIncomingEvent {
//    ExerciseId id;
//    ExerciseName name;
//    ExerciseDescription description;
//    Set<MuscleGroup> muscleGroups;
//    Set<Equipment> equipment;
//    Difficulty difficulty;
//    ExerciseType type;
//
//    @Override
//    public UUID getAggregateId() {
//        return id.getValue();
//    }
//
//}
