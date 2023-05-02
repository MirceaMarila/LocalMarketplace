package com.example.LocalMarketplace.mapper;


import com.example.LocalMarketplace.dto.CartDto;
import com.example.LocalMarketplace.model.Cart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CartMapper {

    public Cart CartDtoToCartMapper(CartDto cartDto) {
        Cart cart = new Cart();

        cart.setProductIds(cartDto.getProductIds());
        cart.setProductQuantity(cartDto.getProductQuantity());

        return cart;
    }

}
