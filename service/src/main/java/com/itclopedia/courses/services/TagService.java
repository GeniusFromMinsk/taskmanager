package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.TagRepository;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsException;
import com.itclopedia.courses.models.Tag;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
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
        if (tagRepository.existsById(tag.getId())) {
            throw new EntityAlreadyExistsException("Tag", tag.getId());
        }
        tagRepository.save(tag);
    }

    public void updateTag(Tag tag) {
        if (!tagRepository.existsById(tag.getId())) {
            throw new EntityNotFoundException("Tag", tag.getId());
        }
        tagRepository.save(tag);
    }

    public void deleteTag(int tagId) {
        if (!tagRepository.existsById(tagId)) {
            throw new EntityNotFoundException("Tag", tagId);
        }
        tagRepository.deleteById(tagId);
    }

    public Tag getTagById(int id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tag", id));
    }
}
