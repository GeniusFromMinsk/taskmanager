package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.CategoryRepository;
import com.itclopedia.courses.models.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);

    }

    public Category getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }
}
