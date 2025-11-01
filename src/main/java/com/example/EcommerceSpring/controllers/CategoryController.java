package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.CreateCategoryRequestDTO;
import com.example.EcommerceSpring.services.ICategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    // private CategoryService categoryService;
    // (has - a) relationship but this voilates dependency inversion principle
    // two high level concrete class should not directly depends on each other
    // why its bad scenario
    // lets consider there are two catory services. one contains all logics for business logic elated to fakestore
    // and other will have business logic related to database related
    // so thats why both should depend on abstraction as one changes does not affect other

    private final ICategoryService categoryService;
//    @Autowired (field based DI)
//    private final ICategoryService categoryService;
    public CategoryController(@Qualifier("CategoryService") ICategoryService categoryService){
        this.categoryService = categoryService;
    }
   @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {
       List<CategoryDTO> result = categoryService.getAllCategories();
        return ResponseEntity.ok(result);
   }

   @PostMapping
   public ResponseEntity<CategoryDTO> createCategory(@RequestBody CreateCategoryRequestDTO dto){
       CategoryDTO category = categoryService.createCategory(dto);
       return ResponseEntity.ok(category);
   }
}
