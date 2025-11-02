package com.example.EcommerceSpring.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllProductsOfCategoryDTO {
    Long categoryId;
    String name;
    List<ProductDTO> products;
}
