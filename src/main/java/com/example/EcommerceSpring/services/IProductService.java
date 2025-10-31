package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.CreateProductRequestDTO;
import com.example.EcommerceSpring.dtos.ProductDTO;
import com.example.EcommerceSpring.entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductService {
    public List<ProductDTO> getAllProduct();
    public ProductDTO getProductById(Long productId);
    public ProductDTO createProduct(CreateProductRequestDTO productDTO) throws Exception;
}
