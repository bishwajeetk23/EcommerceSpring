package com.example.EcommerceSpring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class categoryController {
    @GetMapping
    public String getCategorie(){
        return "haluwa";
    }

    @GetMapping("/count")
    public int getCategorieCount(){
        return 5;
    }
}
