package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.CategoryDAO;
import com.itclopedia.courses.models.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryService {

    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public void addCategory(Category category) {
        log.info("Adding category: {}", category);
        categoryDAO.insertCategory(category);
        log.info("Category added successfully: {}", category);
    }

    public boolean updateCategory(Category category) {
        log.info("Updating category: {}", category);
        boolean result = categoryDAO.updateCategory(category);
        if (result) {
            log.info("Category updated successfully: {}", category);
        } else {
            log.warn("Failed to update category: {}", category);
        }
        return result;
    }

    public boolean deleteCategory(int categoryId) {
        log.info("Deleting category with ID: {}", categoryId);
        boolean result = categoryDAO.deleteCategory(categoryId);
        if (result) {
            log.info("Category deleted successfully with ID: {}", categoryId);
        } else {
            log.warn("Failed to delete category with ID: {}", categoryId);
        }
        return result;
    }

    public Category getCategoryById(int categoryId) {
        log.info("Fetching category with ID: {}", categoryId);
        Category category = categoryDAO.getCategoryById(categoryId);
        if (category != null) {
            log.info("Category found: {}", category);
        } else {
            log.warn("Category not found with ID: {}", categoryId);
        }
        return category;
    }
}
