package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertCategory(Category category) {
        entityManager.persist(category);
    }

    public boolean updateCategory(Category category) {
        entityManager.merge(category);
        return true;
    }

    public boolean deleteCategory(int categoryId) {
        Category category = entityManager.find(Category.class, categoryId);
        if (category != null) {
            entityManager.remove(category);
            return true;
        }
        return false;
    }

    public Category getCategoryById(int categoryId) {
        return entityManager.find(Category.class, categoryId);
    }
}
