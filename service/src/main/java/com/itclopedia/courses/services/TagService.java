package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.TagDAO;
import com.itclopedia.courses.models.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TagService {

    private final TagDAO tagDAO;

    @Autowired
    public TagService(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    public void addTag(Tag tag) {
        log.info("Adding tag: {}", tag);
        tagDAO.insertTag(tag);
        log.info("Tag added successfully: {}", tag);
    }

    public void deleteTag(int tagId) {
        log.info("Deleting tag with ID: {}", tagId);
        tagDAO.deleteTag(tagId);
        log.info("Tag deleted successfully with ID: {}", tagId);
    }

    public void updateTag(Tag tag) {
        log.info("Updating tag: {}", tag);
        tagDAO.updateTag(tag);
        log.info("Tag updated successfully: {}", tag);
    }

    public Tag getTagById(int id) {
        log.info("Fetching tag with ID: {}", id);
        Tag tag = tagDAO.getTagById(id);
        if (tag != null) {
            log.info("Tag found: {}", tag);
        } else {
            log.warn("Tag not found with ID: {}", id);
        }
        return tag;
    }
}
