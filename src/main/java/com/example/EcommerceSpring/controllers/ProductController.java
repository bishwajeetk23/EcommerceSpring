package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dtos.CreateProductRequestDTO;
import com.example.EcommerceSpring.dtos.ProductDTO;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.services.IProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService){
        this.productService = productService;
    }
    // createproduct
    // getallproduct

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        List<ProductDTO> response = productService.getAllProduct();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId){
        ProductDTO response = productService.getProductById(productId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody CreateProductRequestDTO dto) throws Exception{
        ProductDTO response = productService.createProduct(dto);
        return ResponseEntity.ok(response);
    }
    // getproductbytid --> done
    // createproduct -----> done
    // deleteproductby id
    // getproductwithcategory
}
