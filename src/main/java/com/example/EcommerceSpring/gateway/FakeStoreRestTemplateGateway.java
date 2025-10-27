package com.example.EcommerceSpring.gateway;


import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.FakeStoreResponseCategoryDTO;
import com.example.EcommerceSpring.mappers.CategoryMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("FakeStoreRestTemplate")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "http://localhost:9011/api/category";
        ResponseEntity<FakeStoreResponseCategoryDTO> response =  restTemplate.getForEntity(url, FakeStoreResponseCategoryDTO.class);
        if(response.getBody() == null) throw new IOException();
        return response.getBody().getCategories().stream().map((String name)-> CategoryMapper.fakeStoreResponseCategoryDTOtoCategoryDTO(name)).toList();
    }
}
