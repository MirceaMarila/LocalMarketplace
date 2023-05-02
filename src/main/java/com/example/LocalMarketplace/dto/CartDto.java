package com.example.LocalMarketplace.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class CartDto {

    @NotNull(message = "quantity must not be null")
    private ArrayList<Integer> productQuantity;


    @NotNull(message = "id's must not be null")
    private ArrayList<Integer> productIds;

    public ArrayList<Integer> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(ArrayList<Integer> productQuantity) {
        this.productQuantity = productQuantity;
    }

    public ArrayList<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(ArrayList<Integer> productIds) {
        this.productIds = productIds;
    }

}
