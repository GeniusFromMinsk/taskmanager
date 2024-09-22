package com.itclopedia.courses.controller;

import com.itclopedia.courses.models.Tag;
import com.itclopedia.courses.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tags")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity<String> addTag(@RequestBody Tag tag) {
        tagService.addTag(tag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateTag(@RequestBody Tag tag) {
        tagService.updateTag(tag);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable int id) {
        return new ResponseEntity<>(tagService.getTagById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTag(@PathVariable int id) {
        tagService.deleteTag(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
