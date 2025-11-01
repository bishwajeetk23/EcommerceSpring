package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.CreateCategoryRequestDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories() throws IOException;
    CategoryDTO createCategory(CreateCategoryRequestDTO dto);
}
