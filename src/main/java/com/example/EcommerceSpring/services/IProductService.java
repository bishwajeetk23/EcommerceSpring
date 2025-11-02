package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.CreateProductRequestDTO;
import com.example.EcommerceSpring.dtos.ProductDTO;
import com.example.EcommerceSpring.dtos.ProductWithCategoryDTO;
import com.example.EcommerceSpring.entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductService {
    public List<ProductDTO> getAllProduct();
    public List<ProductDTO> getAllProductWithMinPrice(int minPrice);

    public ProductDTO getProductById(Long productId);
    public ProductDTO createProduct(CreateProductRequestDTO productDTO) throws Exception;
    public List<ProductDTO> searchFullText(String searchText) throws Exception;
    public ProductWithCategoryDTO getProductWithCategoryById(Long productId)  throws Exception;
}
