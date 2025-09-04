package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dtos.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    List<CategoryDTO> getAllCategories() throws IOException;
}
