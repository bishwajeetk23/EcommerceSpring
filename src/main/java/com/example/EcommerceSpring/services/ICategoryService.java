package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.AllProductsOfCategoryDTO;
import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.CreateCategoryRequestDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories() throws IOException;
    CategoryDTO createCategory(CreateCategoryRequestDTO dto);
    CategoryDTO getCategoryById(Long categoryId)  throws Exception;
    CategoryDTO getByName(String name) throws Exception;
    AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception;
}
