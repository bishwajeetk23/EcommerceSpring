package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.mappers.CategoryMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("CategoryService")
public class CatrgoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    public CatrgoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        System.out.println("Service is called");
        List<Category> categoryList = this.categoryRepository.findAll();
        return categoryList.stream().map((Category category)-> CategoryMapper.entityToCategoryDTO(category)).toList();
    }
}
