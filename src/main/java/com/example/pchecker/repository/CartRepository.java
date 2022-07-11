package com.example.pchecker.repository;

import com.example.pchecker.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Iterable<Cart> findByUserUsername(String username);
}
