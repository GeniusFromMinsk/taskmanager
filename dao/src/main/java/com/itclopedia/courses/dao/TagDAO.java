package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Tag;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TagDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertTag(Tag tag) {
        entityManager.persist(tag);
    }

    public void deleteTag(int tagId) {
        Tag tag = entityManager.find(Tag.class, tagId);
        if (tag != null) {
            entityManager.remove(tag);
        }
    }

    public void updateTag(Tag tag) {
        entityManager.merge(tag);
    }

    public Tag getTagById(int id) {
        return entityManager.find(Tag.class, id);
    }
}
