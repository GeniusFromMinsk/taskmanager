package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.CategoryRepository;
import com.itclopedia.courses.dto.CategoryDTO;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsException;
import com.itclopedia.courses.mapper.CategoryMapper;
import com.itclopedia.courses.models.Category;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;


    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toCategory(categoryDTO);
        if (categoryRepository.existsById(category.getId())) {
            throw new EntityAlreadyExistsException("Category", category.getId());
        }
        categoryRepository.save(category);
    }

    public void updateCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toCategory(categoryDTO);
        if (!categoryRepository.existsById(category.getId())) {
            throw new EntityNotFoundException("Category", category.getId());
        }
        categoryRepository.save(category);
    }

    public void deleteCategory(int categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new EntityNotFoundException("Category", categoryId);
        }
        categoryRepository.deleteById(categoryId);
    }

    public CategoryDTO getCategoryById(int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category", categoryId));
        return categoryMapper.toCategoryDTO(category);
    }
}
