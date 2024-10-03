package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.ProjectRepository;
import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.dto.ProjectDTO;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsException;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
import com.itclopedia.courses.mapper.ProjectMapper;
import com.itclopedia.courses.models.Project;
import com.itclopedia.courses.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper = ProjectMapper.INSTANCE;
    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public void addProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toProject(projectDTO, userRepository);
        User user = userRepository.findById(projectDTO.getUserId())
                .orElseThrow(() -> new EntityAlreadyExistsException("User", projectDTO.getUserId()));
        project.setUser(user);
        projectRepository.save(project);
    }

    public void updateProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toProject(projectDTO, userRepository);
        User user = userRepository.findById(projectDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User", projectDTO.getUserId()));
        project.setUser(user);
        projectRepository.save(project);
    }

    public ProjectDTO getProjectById(int id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project", id));
        return projectMapper.toProjectDTO(project);
    }

    public void deleteProject(int id) {
        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Project", id);
        }
        projectRepository.deleteById(id);
    }
}
