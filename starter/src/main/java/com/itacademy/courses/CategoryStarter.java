package com.itacademy.courses;

import com.itacademy.courses.config.AppConfig;
import com.itacademy.courses.dao.CategoryDAO;
import com.itacademy.courses.models.Category;
import com.itacademy.courses.services.CategoryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryStarter {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CategoryService categoryService = context.getBean(CategoryService.class);

        Category newCategory = new Category();
        newCategory.setName("New Category");
        newCategory.setDescription("Description of the new category");

        categoryService.addCategory(newCategory);
        System.out.println("Category added: " + newCategory);

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
        context.close();
    }
}
