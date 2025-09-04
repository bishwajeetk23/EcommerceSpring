package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.gateway.FakeStoreCategoryGateway;
import com.example.EcommerceSpring.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService{
    private final ICategoryGateway categoryGateway;
    public FakeStoreCategoryService(ICategoryGateway categoryGateway){
        this.categoryGateway = categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return categoryGateway.getAllCategories();
    }
}
