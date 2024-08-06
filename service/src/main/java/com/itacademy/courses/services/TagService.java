package com.itacademy.courses.services;

import com.itacademy.courses.dao.TagDAO;
import com.itacademy.courses.models.Tag;

public class TagService {
    private final TagDAO tagDAO;

    public TagService() {
        this.tagDAO = new TagDAO();
    }

    public void addTag(Tag tag) {
        tagDAO.insertTag(tag);
    }

    public boolean deleteTag(int tagId) {
        return tagDAO.deleteTag(tagId);
    }

    public boolean updateTag(Tag tag) {
        return tagDAO.updateTag(tag);
    }

    public Tag getTagById(int id) {
        return tagDAO.getTagById(id);
    }
}
