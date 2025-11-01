package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.CreateCategoryRequestDTO;
import com.example.EcommerceSpring.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("FakeStoreCategoryService")
public class FakeStoreCategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;
    public FakeStoreCategoryService(@Qualifier("FakeStoreRestTemplate") ICategoryGateway categoryGateway){
        this.categoryGateway = categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        System.out.println("FakeStore service called");
        return this.categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CreateCategoryRequestDTO dto){
        return null;
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId)  throws Exception{
        return null;
    }
}
