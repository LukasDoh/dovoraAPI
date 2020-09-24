package com.dovora.dovoraAPI.controller;

import com.dovora.dovoraAPI.exception.CategoryNotFoundException;
import com.dovora.dovoraAPI.model.Category;
import com.dovora.dovoraAPI.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for Rest API route '/categories'
 * All interactions with table category
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allow CORS
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    // Get all categories
    @GetMapping("/categories")
    public List<Category> getAllNotes() { return categoryRepository.findAll(); }

    // Create a new category
    @PostMapping("/categories")
    public Category createNote(@Valid @RequestBody Category category) {
        return categoryRepository.save(category);
    }

    // Get a single category by ID
    @GetMapping("/categories/{id}")
    public Category getNoteById(@PathVariable(value= "id") Long categoryId) throws CategoryNotFoundException {
        return categoryRepository.findById(categoryId).
                orElseThrow(() -> new CategoryNotFoundException(categoryId));
    }

    // Update a category
    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable(value = "id") Long categoryId,
                                   @Valid @RequestBody Category categoryDetails) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        category.setName(categoryDetails.getName());
        Category updatedCategory = categoryRepository.save(category);

        return updatedCategory;
    }

    // Delete a category
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Long categoryId) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        categoryRepository.delete(category);
        
        return ResponseEntity.ok().build();
    }
}
