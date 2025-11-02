package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dtos.AllProductsOfCategoryDTO;
import com.example.EcommerceSpring.dtos.CategoryDTO;
import com.example.EcommerceSpring.dtos.CreateCategoryRequestDTO;
import com.example.EcommerceSpring.dtos.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.mappers.CategoryMapper;
import com.example.EcommerceSpring.mappers.ProductMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("CategoryService")
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        System.out.println("Service is called");
        List<Category> categoryList = this.categoryRepository.findAll();
        return categoryList.stream().map(CategoryMapper::entityToCategoryDTO).toList();
    }
    @Override
    public CategoryDTO createCategory(CreateCategoryRequestDTO dto){
        Category category = categoryRepository.save(CategoryMapper.createCategoryRequestDTOtoCategoryEntity(dto));
        return CategoryMapper.toCategoryDTO(category);
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) throws Exception{
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new Exception("Category id: "+categoryId+" not found !!"));
        return CategoryMapper.toCategoryDTO(category);
    }

    @Override
    public CategoryDTO getByName(String name) throws Exception {
        Category category = categoryRepository.findByName(name).orElseThrow(()-> new Exception("No category found by name: " + name));
        return CategoryMapper.toCategoryDTO(category);
    }
    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new Exception("Category not found of id: "+categoryId));
        List<ProductDTO> products = category.getProducts().stream().map(ProductMapper::toProductDTO).toList();
        return CategoryMapper.toAllProductOfCategory(category,products);
    }
}
