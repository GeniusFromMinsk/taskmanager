package com.itclopedia.courses.mapper;

import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.dto.TaskDTO;
import com.itclopedia.courses.models.Task;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO toTaskDTO(Task task);
    Task toTask(TaskDTO taskDTO, @Context UserRepository userRepository);  // добавляем контекст для поиска User

}
