package com.example.pchecker.controllers;

import com.example.pchecker.pojo.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> getProduct(@PathVariable String code) {

		if (productRepository.findByCode(code).isPresent())
			return ResponseEntity.ok(productRepository.findByCode(code).get());

		return ResponseEntity.badRequest().
				body(new MessageResponse("Product Not Found with code " + code));
	}
}
