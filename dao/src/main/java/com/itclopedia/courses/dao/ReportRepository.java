package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Query("SELECT r FROM Report r WHERE r.id = :reportId AND r.user.id = :userId")
    Optional<Report> findByIdAndUserId(@Param("reportId") int reportId, @Param("userId") int userId);
}
