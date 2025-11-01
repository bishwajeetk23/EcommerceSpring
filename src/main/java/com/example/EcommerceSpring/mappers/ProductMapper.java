package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.CreateProductRequestDTO;
import com.example.EcommerceSpring.dtos.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;

public class ProductMapper {
    public static ProductDTO toProductDTO(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .color(product.getColor())
                .image(product.getImage())
                .categoryId(product.getCategory().getId())
                .model(product.getModel())
                .brand(product.getBrand())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .discount(product.getDiscount())
                .popular(product.isPopular())
                .build();
    }
    public static Product productDTOtoProductEntity(ProductDTO product, Category category){
        return Product.builder()
                .image(product.getImage())
                .model(product.getModel())
                .price(product.getPrice())
                .title(product.getTitle())
                .color(product.getColor())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .category(category)
                .build();
    }
    public static Product CreateProductRequestDTOtoProductEntity(CreateProductRequestDTO product, Category category){
        return Product.builder()
                .image(product.getImage())
                .model(product.getModel())
                .price(product.getPrice())
                .title(product.getTitle())
                .color(product.getColor())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .category(category)
                .build();
    }
}
