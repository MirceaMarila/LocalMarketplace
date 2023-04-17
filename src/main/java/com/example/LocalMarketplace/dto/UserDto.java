package com.example.LocalMarketplace.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDto {

    @NotNull(message = "farmer must not be null")
    private final Boolean farmer;

    @NotNull(message = "name must not be null")
    @NotBlank(message = "name must not be blank")
    private final String name;

    @NotNull(message = "email must not be null")
    @NotBlank(message = "email must not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+=?^_`{|}~-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]+$", message = "email does not have a valid structure")
    private final String email;

    @NotNull(message = "password must not be null")
    @NotBlank(message = "password must not be blank")
    private final String password;

    public UserDto(Boolean farmer, String name, String email, String password) {
        this.farmer = farmer;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Boolean getFarmer() {
        return farmer;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
