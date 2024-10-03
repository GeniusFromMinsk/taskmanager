package com.itclopedia.courses.controller;

import com.itclopedia.courses.dto.TagDTO;
import com.itclopedia.courses.dto.UserDTO;
import com.itclopedia.courses.models.Tag;
import com.itclopedia.courses.services.TagService;
import com.sun.source.tree.TryTree;
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

    @PostMapping()
    public ResponseEntity<String> addTag(@RequestBody TagDTO tagDTO) {
        try {
            tagService.addTag(tagDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Tag added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<String> updateTag(@RequestBody TagDTO tagDTO) {
        try {
            tagService.updateTag(tagDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Tag updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDTO> getTagById(@PathVariable int id) {
        TagDTO tagDTO = tagService.getTagById(id);
        return ResponseEntity.ok(tagDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTag(@PathVariable int id) {
        tagService.deleteTag(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
