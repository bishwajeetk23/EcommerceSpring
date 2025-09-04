package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.FakeStoreResponseCategoryDTO;
import com.example.EcommerceSpring.gateway.api.FakeStoreCategoryAPI;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{
    // need to add composition with FakeStoreCategoryAPI

    private final FakeStoreCategoryAPI fakeStoreCategoryAPI;

    public FakeStoreCategoryGateway(FakeStoreCategoryAPI fakeStoreCategoryAPI){
        this.fakeStoreCategoryAPI = fakeStoreCategoryAPI;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreResponseCategoryDTO response =  this.fakeStoreCategoryAPI.getAllFakeCategories().execute().body();
        if(response == null) throw new IOException();
        return response.getCategories().stream().map((String category) -> CategoryDTO.builder().name(category).build()).toList();
    }
}
