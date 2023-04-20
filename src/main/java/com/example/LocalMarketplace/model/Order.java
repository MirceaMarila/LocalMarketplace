package com.example.LocalMarketplace.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_ids")
    private ArrayList<Integer> productIds;

    @Column(name = "product_quantity")
    private ArrayList<Integer> productQuantity;

    @Column(name = "product_price")
    private ArrayList<Double> productPrice;

    public Integer getId() {
        return id;
    }

    public ArrayList<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(ArrayList<Integer> productIds) {
        this.productIds = productIds;
    }

    public ArrayList<Integer> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(ArrayList<Integer> productQuantity) {
        this.productQuantity = productQuantity;
    }

    public ArrayList<Double> getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ArrayList<Double> productPrice) {
        this.productPrice = productPrice;
    }
}
