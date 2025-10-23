package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.ProductDTO;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.mappers.ProductMapper;
import com.example.EcommerceSpring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    private ProductRepository repo;

    public ProductService(ProductRepository repo){
        this.repo = repo;
    }
    @Override
    public List<ProductDTO> getAllProduct() {
        // repo.findAll();
        // its type is entity
        return repo.findAll().stream().map((Product product) ->  ProductDTO.builder()
                        .id(product.getId())
                        .brand(product.getBrand())
                        .image(product.getImage())
                        .model(product.getModel())
                        .category(CategoryDTO.builder().name(product.getCategory().getName()).id(product.getCategory().getId()).build())
                        .color(product.getColor())
                        .title(product.getTitle())
                        .build())
                        .toList();
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = repo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
        return ProductMapper.toProductDTO(product);
    }

}
