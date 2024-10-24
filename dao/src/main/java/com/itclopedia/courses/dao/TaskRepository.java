package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>, JpaSpecificationExecutor<Task> {
    @Query("SELECT t FROM Task t WHERE t.id = :taskId AND t.user.id = :userId")
    Optional<Task> findByIdAndUserId(@Param("taskId") int taskId, @Param("userId") int userId);

    @Query("SELECT t FROM Task t WHERE t.user.id = :userId")
    List<Task> findAllByUserId(@Param("userId") int userId);
}
