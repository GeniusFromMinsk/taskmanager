package com.itclopedia.courses;

import com.itclopedia.courses.config.AppConfig;
import com.itclopedia.courses.models.Category;
import com.itclopedia.courses.services.CategoryService;
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
