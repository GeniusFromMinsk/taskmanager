package com.itclopedia.courses;

import com.itclopedia.courses.dao.CategoryRepository;
import com.itclopedia.courses.models.Category;
import com.itclopedia.courses.services.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CategoryServiceTest {

    private CategoryRepository categoryRepository;
    private CategoryService categoryService;

    @BeforeEach
    public void setup() {
        categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void testCreate() {
        Category category = new Category();
        category.setName("Name");
        category.setDescription("Desc");
        categoryService.addCategory(category);
        verify(categoryRepository, times(1)).save(category);
        assertEquals("Name", category.getName());
    }

    @Test
    public void testUpdate() {
        Category category = new Category();
        category.setId(1);
        category.setName("Personal");
        category.setDescription("Desc");
        when(categoryRepository.existsById(category.getId())).thenReturn(true);
        categoryService.updateCategory(category);
        verify(categoryRepository, times(1)).save(category);
        assertEquals("Personal", category.getName());
    }

    @Test
    public void testGet() {
        int id = 36;
        Category category = new Category();
        category.setName("New Category");
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));

        Category retrievedCategory = categoryService.getCategoryById(id);
        assertEquals("New Category", retrievedCategory.getName());
    }

    @Test
    public void testDelete() {
        int id = 46;
        when(categoryRepository.existsById(id)).thenReturn(true);
        categoryService.deleteCategory(id);
        verify(categoryRepository, times(1)).deleteById(id);
    }
}
