package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.request.RegisterRequest;
import com.example.ecommerce.dto.response.RoleResponse;
import com.example.ecommerce.dto.response.UserResponse;
import com.example.ecommerce.entity.Role;
import com.example.ecommerce.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    User toUser (RegisterRequest request);

    UserResponse toUserResponse (User user);

    RoleResponse toRoleResponse (Role role);
}
