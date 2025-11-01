package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.CreateCategoryRequestDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.mappers.CategoryMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("CategoryService")
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        System.out.println("Service is called");
        List<Category> categoryList = this.categoryRepository.findAll();
        return categoryList.stream().map(CategoryMapper::entityToCategoryDTO).toList();
    }
    @Override
    public CategoryDTO createCategory(CreateCategoryRequestDTO dto){
        Category category = categoryRepository.save(CategoryMapper.createCategoryRequestDTOtoCategoryEntity(dto));
        return CategoryMapper.toCategoryDTO(category);
    }
}
