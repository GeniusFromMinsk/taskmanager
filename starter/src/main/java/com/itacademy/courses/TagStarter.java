package com.itacademy.courses;

import com.itacademy.courses.models.Tag;
import com.itacademy.courses.services.TagService;

public class TagStarter {
    public static void main(String[] args) {
        TagService tagService = new TagService();

        Tag newTag = new Tag();
        newTag.setName("New Tag");
        tagService.addTag(newTag);

        newTag.setName("Updated Tag");
        tagService.updateTag(newTag);

        tagService.deleteTag(newTag.getTagId());
    }
}
