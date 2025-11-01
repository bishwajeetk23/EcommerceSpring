package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.CreateCategoryRequestDTO;
import com.example.EcommerceSpring.dtos.FakeStoreResponseCategoryDTO;
import com.example.EcommerceSpring.entity.Category;

public class CategoryMapper {
    public static CategoryDTO toCategoryDTO(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static CategoryDTO entityToCategoryDTO(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static CategoryDTO fakeStoreResponseCategoryDTOtoCategoryDTO(String category){
        return CategoryDTO.builder()
                .name(category)
                .id((1L))
                .build();
    }

    public static Category createCategoryRequestDTOtoCategoryEntity(CreateCategoryRequestDTO category){
        return Category.builder()
                .name(category.getName())
                .build();
    }
}
