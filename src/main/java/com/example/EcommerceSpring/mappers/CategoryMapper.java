package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dtos.*;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;

import java.util.List;

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

    public static AllProductsOfCategoryDTO toAllProductOfCategory(Category category, List<ProductDTO> productList){
        return AllProductsOfCategoryDTO.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .products(productList)
                .build();
    }
}
