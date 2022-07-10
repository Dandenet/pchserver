package com.example.pchecker.repository;

import com.example.pchecker.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepostitory extends JpaRepository<Cart, Long> {
}
