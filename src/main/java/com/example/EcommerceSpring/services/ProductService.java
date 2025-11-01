package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.CreateProductRequestDTO;
import com.example.EcommerceSpring.dtos.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.mappers.ProductMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import com.example.EcommerceSpring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    private ProductRepository repo;
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository repo, CategoryRepository categoryRepository){
        this.repo = repo;
        this.categoryRepository = categoryRepository;
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
                        .categoryId(product.getCategory().getId())
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

    @Override
    public ProductDTO createProduct(CreateProductRequestDTO product) throws Exception{
        Category category = categoryRepository.findById(product.getCategoryId())
                .orElseThrow(()-> new Exception("Category not found"));
        Product productResponse = repo.save(ProductMapper.CreateProductRequestDTOtoProductEntity(product,category));
        return ProductMapper.toProductDTO(productResponse);
    }

}
