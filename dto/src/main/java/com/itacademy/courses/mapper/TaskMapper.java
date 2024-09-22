package com.itacademy.courses.mapper;

import com.itacademy.courses.dto.TaskDTO;
import com.itclopedia.courses.models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO toTaskDTO(Task task);

    Task toTask(TaskDTO taskDTO);
}
