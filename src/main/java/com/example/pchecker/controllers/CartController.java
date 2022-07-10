package com.example.pchecker.controllers;


import com.example.pchecker.models.Cart;
import com.example.pchecker.models.User;
import com.example.pchecker.repository.CartRepostitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
