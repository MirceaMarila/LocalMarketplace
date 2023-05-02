package com.example.LocalMarketplace.mapper;

import com.example.LocalMarketplace.dto.ProductDto;
import com.example.LocalMarketplace.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product ProductDtoToProductMapper(ProductDto productDto, Integer farmerId){
        Product product = new Product();

        product.setFarmerId(farmerId);
        product.setImage(productDto.getImage());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setAvailable(productDto.getAvailable());
        product.setCategory(productDto.getCategory());

        return product;
    }
}
