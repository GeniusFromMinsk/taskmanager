package com.itacademy.courses.services;

import com.itacademy.courses.dao.CategoryDAO;
import com.itacademy.courses.models.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAO();
    }

    public void createCategory(Category category) {
        try {
            categoryDAO.insertCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean updateCategory(Category category) {
        try {
            return categoryDAO.updateCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCategory(int categoryId) {
        try {
            return categoryDAO.deleteCategory(categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}