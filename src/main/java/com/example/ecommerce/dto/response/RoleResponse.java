package com.example.ecommerce.dto.response;

import com.example.ecommerce.entity.RoleName;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {
    private Long id;
    private RoleName name;
}