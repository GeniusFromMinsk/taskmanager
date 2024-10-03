package com.itclopedia.courses.mapper;

import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.dto.ProjectDTO;
import com.itclopedia.courses.models.Project;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    ProjectDTO toProjectDTO(Project project);
    Project toProject(ProjectDTO projectDTO, @Context UserRepository userRepository);

}
