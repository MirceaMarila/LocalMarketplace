package com.example.LocalMarketplace.controller;


import com.example.LocalMarketplace.dto.ProductDto;
import com.example.LocalMarketplace.mapper.ProductMapper;
import com.example.LocalMarketplace.model.Product;
import com.example.LocalMarketplace.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;

@Validated
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping("/farmer/{farmerId}/add")
    public ResponseEntity<Product> saveNewProduct(@PathVariable Integer farmerId, @RequestBody @Valid ProductDto productDto) {
        Product product = productMapper.ProductDtoToProductMapper(productDto, farmerId);
        Product savedProduct = productService.saveNewProduct(product);

        return ResponseEntity.created(URI.create("/id/" + savedProduct.getId())).body(savedProduct);
    }

    @GetMapping("/farmer/{farmerId}/all")
    public ResponseEntity<ArrayList<Product>> findAllProductsByFarmerIf(@PathVariable Integer farmerId) {
        ArrayList<Product> products = productService.getAllProductsOfFarmer(farmerId);

        return ResponseEntity.ok().body(products);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody @Valid ProductDto productDto) {
        Product updatedProduct = productService.updateProduct(productId, productDto);

        return ResponseEntity.created(URI.create("/id/" + updatedProduct.getId())).body(updatedProduct);
    }
}
