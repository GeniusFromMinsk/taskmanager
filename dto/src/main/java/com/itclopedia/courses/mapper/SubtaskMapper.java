package com.itclopedia.courses.mapper;

import com.itclopedia.courses.dao.TaskRepository;
import com.itclopedia.courses.dto.SubtaskDTO;
import com.itclopedia.courses.models.Subtask;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SubtaskMapper {

    SubtaskMapper INSTANCE = Mappers.getMapper(SubtaskMapper.class);

    SubtaskDTO toSubtaskDTO(Subtask subtask);
    Subtask toSubtask(SubtaskDTO subtaskDTO, @Context TaskRepository taskRepository);

}
