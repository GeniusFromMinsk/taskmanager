package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query("SELECT p FROM Project p WHERE p.id = :projectId AND p.user.id = :userId")
    Optional<Project> findByIdAndUserId(@Param("projectId") int projectId, @Param("userId") int userId);
}
