package com.example.pchecker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import com.example.pchecker.repository.ProductRepository;
import com.example.pchecker.models.Product;


@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

	@Autowired
	private ProductRepository productRepository;


	@GetMapping("/{code}")
	public Product getProduct(@PathVariable String code) {
		return productRepository.findByCode(code)
				.orElseThrow(() -> new RuntimeException("Product Not Found with code " + code));
	}
}
