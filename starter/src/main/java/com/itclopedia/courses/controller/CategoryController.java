package com.itclopedia.courses.controller;

import com.itclopedia.courses.models.Category;
import com.itclopedia.courses.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
