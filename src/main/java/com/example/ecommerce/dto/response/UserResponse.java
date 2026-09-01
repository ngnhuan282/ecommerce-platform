package com.example.ecommerce.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class UserResponse {
    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String phone;

    private String status;

    private Set<String> roles;
}
