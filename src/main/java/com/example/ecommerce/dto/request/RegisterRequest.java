package com.example.ecommerce.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "INVALID_EMAIL")
    @Email(message = "INVALID_EMAIL")
    private String email;

    @NotBlank(message = "INVALID_PASSWORD")
    @Size(
            min = 6,
            message = "INVALID_PASSWORD"
    )
    private String password;

    @NotBlank(message = "INVALID_FIRST_NAME")
    private String firstName;

    @NotBlank(message = "INVALID_LAST_NAME")
    private String lastName;

    private String phone;
}
