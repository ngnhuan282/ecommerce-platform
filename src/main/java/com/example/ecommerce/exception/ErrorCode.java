package com.example.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {

    UNCATEGORIZED_EXCEPTION(
            9999,
            "Uncategorized error",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),

    INVALID_KEY(
            1001,
            "Invalid key",
            HttpStatus.BAD_REQUEST
    ),

    USER_EXISTED(
            1002,
            "User already exists",
            HttpStatus.BAD_REQUEST
    ),

    USER_NOT_EXISTED(
            1003,
            "User not found",
            HttpStatus.NOT_FOUND
    ),

    INVALID_PASSWORD(
            1004,
            "Password must be at least {min} characters",
            HttpStatus.BAD_REQUEST
    ),

    UNAUTHENTICATED(
            1005,
            "Unauthenticated",
            HttpStatus.UNAUTHORIZED
    ),

    UNAUTHORIZED(
            1006,
            "You do not have permission",
            HttpStatus.FORBIDDEN
    ),

    PRODUCT_NOT_FOUND(
            1007,
            "Product not found",
            HttpStatus.NOT_FOUND
    ),

    CATEGORY_NOT_FOUND(
            1008,
            "Category not found",
            HttpStatus.NOT_FOUND
    ),

    INSUFFICIENT_STOCK(
            1009,
            "Insufficient stock",
            HttpStatus.BAD_REQUEST
    ),

    ORDER_NOT_FOUND(
            1010,
            "Order not found",
            HttpStatus.NOT_FOUND
    ),

    INVALID_ORDER_STATUS(
            1011,
            "Invalid order status",
            HttpStatus.BAD_REQUEST
    ),

    CART_NOT_FOUND(
            1012,
            "Cart not found",
            HttpStatus.NOT_FOUND
    ),

    CART_EMPTY(
            1013,
            "Cart is empty",
            HttpStatus.BAD_REQUEST
    ),

    ADDRESS_NOT_FOUND(
            1014,
            "Address not found",
            HttpStatus.NOT_FOUND
    ),

    PAYMENT_FAILED(
            1015,
            "Payment failed",
            HttpStatus.BAD_REQUEST
    ),

    INVALID_EMAIL(
            1100,
            "Invalid email",
            HttpStatus.BAD_REQUEST
    ),

    INVALID_FIRST_NAME(
            1101,
            "First name is required",
            HttpStatus.BAD_REQUEST
    ),

    INVALID_LAST_NAME(
            1102,
            "Last name is required",
            HttpStatus.BAD_REQUEST
    );



    ErrorCode(
            int code,
            String message,
            HttpStatusCode statusCode
    ) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}