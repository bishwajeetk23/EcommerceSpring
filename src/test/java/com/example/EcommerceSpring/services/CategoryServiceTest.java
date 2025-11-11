package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

// @ExtendWith(MockitoExtension.class) ----> this integrate mockito into junit for mocking calls
// This annotation is used to enable Mockito for the test class with JUnit
@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    @DisplayName("Should return all categories successfully!")
    void getAllCategories_shouldReturnAllCategory() throws IOException {
        // Arrange
        List<Category> categories = new ArrayList<>();
        Category category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        Category category2 = Category.builder().name("Books").build();
        category2.setId(2L);
        Category category3 = Category.builder().name("Clothing").build();
        category3.setId(3L);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        when(categoryRepository.findAll()).thenReturn(categories);

        // Act

        List<CategoryDTO> result = categoryService.getAllCategories();

        // Assert
        assertEquals(3,result.size());
        verify(categoryRepository,times(1)).findAll();
    }
}
