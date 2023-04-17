package com.example.LocalMarketplace.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ProductDto {

    @NotNull(message = "image must not be null")
    @NotBlank(message = "image must not be blank")
    private final String image;

    @NotNull(message = "name must not be null")
    @NotBlank(message = "name must not be blank")
    private final String name;

    @NotNull(message = "price must not be null")
    private final Double price;

    @NotNull(message = "available must not be null")
    private final Integer available;

    @NotNull(message = "category must not be null")
    @NotBlank(message = "category must not be blank")
    private final String category;

    public ProductDto(String image, String name, Double price, Integer available, String category) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.available = available;
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAvailable() {
        return available;
    }

    public String getCategory() {
        return category;
    }
}
