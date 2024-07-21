package com.itacademy.courses.services;

import com.itacademy.courses.dao.CategoryDAO;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Category;

import java.sql.SQLException;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAO();
    }

    public void createCategory(Category category) {
        try {
            categoryDAO.insertCategory(category);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }


    public boolean updateCategory(Category category) {
        try {
            return categoryDAO.updateCategory(category);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            return false;
        }
    }

    public boolean deleteCategory(int categoryId) {
        try {
            return categoryDAO.deleteCategory(categoryId);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            return false;
        }
    }
}