package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
