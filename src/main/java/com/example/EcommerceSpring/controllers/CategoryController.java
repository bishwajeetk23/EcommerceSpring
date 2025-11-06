package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dtos.AllProductsOfCategoryDTO;
import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.CreateCategoryRequestDTO;
import com.example.EcommerceSpring.dtos.ProductDTO;
import com.example.EcommerceSpring.exception.CategoryNotFoundException;
import com.example.EcommerceSpring.services.ICategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception {
        if(name != null && !name.isBlank()){
            CategoryDTO response = categoryService.getByName(name);
            return ResponseEntity.ok(response);
        }
       List<CategoryDTO> result = categoryService.getAllCategories();
        return ResponseEntity.ok(result);
   }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long categoryId) throws Exception {
        CategoryDTO result = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(result);
    }

   @PostMapping
   public ResponseEntity<CategoryDTO> createCategory(@RequestBody CreateCategoryRequestDTO dto){
       CategoryDTO category = categoryService.createCategory(dto);
       return ResponseEntity.ok(category);
   }

   @GetMapping("/{id}/products")
    public ResponseEntity<AllProductsOfCategoryDTO> getAllProductOfCategory(@PathVariable Long id) throws  Exception{
        AllProductsOfCategoryDTO response = categoryService.getAllProductsOfCategory(id);
        return ResponseEntity.ok(response);
   }

//   @ExceptionHandler(CategoryNotFoundException.class)
//    public ResponseEntity<String> handleCategoryNotFound(CategoryNotFoundException ex){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//   }
}
