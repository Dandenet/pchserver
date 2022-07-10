package com.example.pchecker.controllers;


import com.example.pchecker.models.Cart;
import com.example.pchecker.repository.CartRepostitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CartController {

    @Autowired
    private CartRepostitory cartRepostitory;

    @GetMapping("/all")
    public Iterable<Cart> all() {
        return cartRepostitory.findAll();
    }
}
