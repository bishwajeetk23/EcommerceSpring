package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories() throws IOException;
}
