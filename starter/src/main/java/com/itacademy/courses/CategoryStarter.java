package com.itacademy.courses;

import com.itacademy.courses.models.Category;
import com.itacademy.courses.services.CategoryService;

public class CategoryStarter {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();

        Category newCategory = new Category();
        newCategory.setName("New Category");
        newCategory.setDescription("Description of the new category");
        categoryService.addCategory(newCategory);

        int newCategoryId = newCategory.getCategoryId();
        System.out.println("Добавлена категория с ID: " + newCategoryId);

        newCategory.setDescription("Updated description");
        categoryService.updateCategory(newCategory);

        Category retrievedCategory = categoryService.getCategoryById(newCategoryId);
        System.out.println("Полученная категория: " + retrievedCategory);

        int categoryIdToDelete = 40;

        boolean isDeleted = categoryService.deleteCategory(categoryIdToDelete);
        if (isDeleted) {
            System.out.println("Категория с ID " + categoryIdToDelete + " успешно удалена.");
        } else {
            System.out.println("Категория с ID " + categoryIdToDelete + " не найдена.");
        }
    }
}
