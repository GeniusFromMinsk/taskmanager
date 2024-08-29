package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.TagDAO;
import com.itclopedia.courses.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    private final TagDAO tagDAO;

    @Autowired
    public TagService(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    public void addTag(Tag tag) {
        tagDAO.insertTag(tag);
    }

    public void deleteTag(int tagId) {
        tagDAO.deleteTag(tagId);
    }

    public void updateTag(Tag tag) {
        tagDAO.updateTag(tag);
    }

    public Tag getTagById(int id) {
        return tagDAO.getTagById(id);
    }
}
