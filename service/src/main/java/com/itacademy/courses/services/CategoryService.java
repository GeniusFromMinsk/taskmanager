package com.itacademy.courses.services;

import com.itacademy.courses.dao.CategoryDAO;
import com.itacademy.courses.models.Category;

public class CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAO();
    }

    public void addCategory(Category category) {
        categoryDAO.insertCategory(category);
    }

    public boolean updateCategory(Category category) {
        return categoryDAO.updateCategory(category);
    }

    public boolean deleteCategory(int categoryId) {
        return categoryDAO.deleteCategory(categoryId);
    }

    public Category getCategoryById(int categoryId) {
        return categoryDAO.getCategoryById(categoryId);
    }
}