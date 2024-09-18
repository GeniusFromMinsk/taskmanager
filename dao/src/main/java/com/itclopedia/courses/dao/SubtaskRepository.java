package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtaskRepository extends JpaRepository<Subtask, Integer> {
}
