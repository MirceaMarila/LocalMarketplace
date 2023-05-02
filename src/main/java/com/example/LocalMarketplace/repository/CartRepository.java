package com.example.LocalMarketplace.repository;

import com.example.LocalMarketplace.model.Cart;
import com.example.LocalMarketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findCartById(Integer cartId);

}
