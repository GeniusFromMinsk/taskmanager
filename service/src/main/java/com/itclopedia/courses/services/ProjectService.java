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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    private final UserService userService;
    private final ProjectMapper projectMapper = ProjectMapper.INSTANCE;
    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository, UserService userService) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public void addProject(ProjectDTO projectDTO) {
        User currentUser = userService.getCurrentUser();
        if (projectDTO.getUserId() != null && !projectDTO.getUserId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You cannot update a project for another user");
        }
        Project project = projectMapper.toProject(projectDTO, userRepository);
        if (projectRepository.existsById(project.getId())) {
            throw new EntityAlreadyExistsException("Project", project.getId());
        }
        project.setUser(currentUser);
        projectRepository.save(project);
    }

    public void updateProject(ProjectDTO projectDTO) {
        User currentUser = userService.getCurrentUser();
        if (projectDTO.getUserId() != null && !projectDTO.getUserId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You cannot update a project for another user");
        }
        Project project = projectMapper.toProject(projectDTO, userRepository);
        if (projectRepository.existsById(project.getId())) {
            throw new EntityNotFoundException("Project", project.getId());
        }
        project.setUser(currentUser);
        projectRepository.save(project);
    }

    public ProjectDTO getProjectById(int id) {
        User currentUser = userService.getCurrentUser();

        Project project = projectRepository.findByIdAndUserId(id, currentUser.getId())
                .orElseThrow(() -> new EntityNotFoundException("Project", id));

        return projectMapper.toProjectDTO(project);
    }

    public void deleteProject(int id) {
        User currentUser = userService.getCurrentUser();

        Project project = projectRepository.findByIdAndUserId(id, currentUser.getId())
                .orElseThrow(() -> new EntityNotFoundException("Project", id));

        projectRepository.delete(project);
    }
}
