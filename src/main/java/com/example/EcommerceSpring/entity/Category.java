package com.example.EcommerceSpring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category extends BaseEntity{

    @Column(nullable = false, unique = true)
    String name;

    @OneToMany(mappedBy = "category")
    List<Product> products;

}
