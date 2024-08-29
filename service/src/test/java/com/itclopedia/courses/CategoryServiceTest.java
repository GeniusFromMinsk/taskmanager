package com.itclopedia.courses;

import com.itclopedia.courses.dao.CategoryDAO;
import com.itclopedia.courses.models.Category;
import com.itclopedia.courses.services.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class CategoryServiceTest {

    private CategoryDAO categoryDAO;
    private CategoryService categoryService;

    @BeforeEach
    public void setup() {
        categoryDAO = Mockito.mock(CategoryDAO.class);
        categoryService = new CategoryService(categoryDAO);
    }

    @Test
    public void testCreate() {
        Category category = new Category();
        category.setName("Name");
        category.setDescription("Desc");

        categoryService.addCategory(category);

        verify(categoryDAO, times(1)).insertCategory(category);
        assertEquals("Name", category.getName());
    }

    @Test
    public void testUpdate() {
        Category category = new Category();
        category.setName("Personal");
        category.setDescription("Desc");

        categoryService.updateCategory(category);

        verify(categoryDAO, times(1)).updateCategory(category);
        assertEquals("Personal", category.getName());
    }

    @Test
    public void testGet() {
        int id = 36;
        Category category = new Category();
        category.setName("New Category");

        when(categoryDAO.getCategoryById(id)).thenReturn(category);

        Category retrievedCategory = categoryService.getCategoryById(id);
        assertEquals("New Category", retrievedCategory.getName());
    }

    @Test
    public void testDelete() {
        int id = 46;

        when(categoryDAO.getCategoryById(id)).thenReturn(null);
        categoryService.deleteCategory(id);

        verify(categoryDAO, times(1)).deleteCategory(id);
        assertNull(categoryService.getCategoryById(id));
    }
}
