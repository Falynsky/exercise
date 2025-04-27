package com.falynsky.mapper;

import com.falynsky.command.NewExerciseCommand;
import com.falynsky.command.UpdateExerciseCommand;
import com.falynsky.in.web.request.NewExerciseRequest;
import com.falynsky.in.web.request.UpdateExerciseRequest;
import org.mapstruct.Mapper;

@Mapper
public interface ExerciseCommandMapper {

    NewExerciseCommand toCommand(NewExerciseRequest request);

    UpdateExerciseCommand toCommand(String id, UpdateExerciseRequest request);
}
