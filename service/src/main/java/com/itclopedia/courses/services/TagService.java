package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.TagRepository;
import com.itclopedia.courses.models.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public void addTag(Tag tag) {
        tagRepository.save(tag);
    }

    public void deleteTag(int tagId) {
        tagRepository.deleteById(tagId);
    }

    public void updateTag(Tag tag) {
        tagRepository.save(tag);
    }

    public Tag getTagById(int id) {
        return tagRepository.findById(id).orElse(null);
    }
}
