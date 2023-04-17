package com.example.LocalMarketplace.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Credentials {

    @NotNull(message = "email must not be null")
    @NotBlank(message = "email must not be blank")
    private final String email;

    @NotNull(message = "password must not be null")
    @NotBlank(message = "password must not be blank")
    private final String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
