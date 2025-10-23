package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.ProductDTO;
import com.example.EcommerceSpring.entity.Product;

public class ProductMapper {
    public static ProductDTO toProductDTO(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .color(product.getColor())
                .image(product.getImage())
                .category(CategoryMapper.toCategoryDTO(product.getCategory()))
                .model(product.getModel())
                .brand(product.getBrand())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .discount(product.getDiscount())
                .popular(product.isPopular())
                .build();
    }
}
