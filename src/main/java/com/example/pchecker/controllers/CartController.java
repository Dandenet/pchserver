package com.example.pchecker.controllers;


import com.example.pchecker.models.Cart;
import com.example.pchecker.models.Product;
import com.example.pchecker.models.User;
import com.example.pchecker.pojo.UpdateCartRequest;
import com.example.pchecker.repository.CartRepository;

import com.example.pchecker.repository.ProductRepository;
import com.example.pchecker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CartController {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public Iterable<Cart> all() {
        return cartRepository.findAll();
    }

    @GetMapping("/user/{username}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Iterable<Cart> getUserCart(@PathVariable String username) {
        return cartRepository.findByUserUsername(username);
    }

    @PostMapping("/user/{username}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Cart updateCart(@RequestBody UpdateCartRequest cartRequest, @PathVariable String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow( () -> new RuntimeException( "Not Found User with username " + username ));

        Product product = productRepository.findById(cartRequest.getId())
                .orElseThrow( () -> new RuntimeException("Not Found Product with id " + cartRequest.getId()));

        return cartRepository.save(new Cart(user, product, cartRequest.getQuantity()));
    }
}
