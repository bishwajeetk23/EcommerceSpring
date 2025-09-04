package com.example.EcommerceSpring.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreResponseCategoryDTO {
    private String status;
    private String message;
    private List<String> categories;
}
