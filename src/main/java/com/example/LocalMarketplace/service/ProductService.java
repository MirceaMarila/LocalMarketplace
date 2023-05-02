package com.example.LocalMarketplace.service;

import com.example.LocalMarketplace.dto.ProductDto;
import com.example.LocalMarketplace.exceptions.BadRequest;
import com.example.LocalMarketplace.model.Product;
import com.example.LocalMarketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveNewProduct(Product product){

        Product existingProduct = productRepository.findProductByName(product.getName());
        if (existingProduct != null)
            throw new BadRequest("A product with this name already exists!");

        return productRepository.save(product);
    }

    public ArrayList<Product> getAllProductsOfFarmer(Integer farmerId){
        return productRepository.findAllProductByFarmerId(farmerId);
    }

    public Product updateProduct(Integer productId, ProductDto productDto){

        Product existingProduct = productRepository.findProductById(productId);
        if (existingProduct == null)
            throw new BadRequest("The product with id " + productId + " does not exist!");

        existingProduct.setAvailable(productDto.getAvailable());
        existingProduct.setCategory(productDto.getCategory());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setImage(productDto.getImage());
        existingProduct.setName(productDto.getName());

        return productRepository.save(existingProduct);
    }

    public ArrayList<Product> getAllProductsByName(String productName) {
        return productRepository.findAllProductByName(productName);
    }

 /*   public ArrayList<Product> getAllProductsByUserId(Integer userId) {
        return productRepository.findAllProductByUserId(userId);
    }*/

    public ArrayList<Product> getAllProductsAvailable(Integer avaialable) {

       return productRepository.findProductByAvailableGreaterThan(avaialable);

    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


    public ArrayList<Product> findAllProductsByCategory(String categoryName) {

        return productRepository.findProductByCategory(categoryName);
    }
}
