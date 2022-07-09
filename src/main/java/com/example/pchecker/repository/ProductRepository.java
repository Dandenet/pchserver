package com.example.pchecker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.pchecker.models.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(String code);
}
