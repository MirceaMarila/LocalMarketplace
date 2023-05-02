package com.example.LocalMarketplace.service;

import com.example.LocalMarketplace.exceptions.BadRequest;
import com.example.LocalMarketplace.model.Cart;
import com.example.LocalMarketplace.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {


    CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public Cart saveNewCart(Cart cart) {

        Cart existingCart = cartRepository.findCartById(cart.getId());
        if(existingCart != null)
            throw new BadRequest("Cart already exists!");

        return cartRepository.save(cart);

    }
}
