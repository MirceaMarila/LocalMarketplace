package com.example.LocalMarketplace.repository;

import com.example.LocalMarketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(Integer id);

    Product findProductByName(String name);

    ArrayList<Product> findAllProductByFarmerId(Integer farmerId);

    ArrayList<Product> findAllProductByName(String name);

    /*ArrayList<Product> findAllProductByUserId(Integer userId);*/

    ArrayList<Product> findProductByAvailableGreaterThan(Integer available);

    ArrayList<Product> findProductByCategory(String categoryName);


}
