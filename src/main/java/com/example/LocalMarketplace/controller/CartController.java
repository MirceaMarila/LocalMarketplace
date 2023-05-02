package com.example.LocalMarketplace.controller;

import com.example.LocalMarketplace.dto.CartDto;
import com.example.LocalMarketplace.mapper.CartMapper;
import com.example.LocalMarketplace.model.Cart;
import com.example.LocalMarketplace.repository.CartRepository;
import com.example.LocalMarketplace.repository.ProductRepository;
import com.example.LocalMarketplace.service.CartService;
import com.example.LocalMarketplace.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@Validated
@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    private final ProductService productService;

    private final ProductRepository productRepository;

    private final CartRepository cartRepository;

    private final CartMapper cartMapper;

    public CartController(CartService cartService, ProductService productService, CartRepository cartRepository, CartMapper cartMapper, ProductRepository productRepository) {
        this.cartService = cartService;
        this.productService = productService;
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
        this.productRepository = productRepository;
    }

    @PostMapping("/new")
    public ResponseEntity<Cart> saveNewCart(@RequestBody @Valid CartDto cartDto) {
        Cart cart = cartMapper.CartDtoToCartMapper(cartDto);
        Cart savedCart = cartService.saveNewCart(cart);

        return ResponseEntity.created(URI.create("/id/" + savedCart.getId())).body(savedCart);
    }






}
