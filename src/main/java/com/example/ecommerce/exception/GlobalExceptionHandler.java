package com.example.ecommerce.exception;

import com.example.ecommerce.dto.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.Objects;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final String MIN_ATTRIBUTE = "min";

    @ExceptionHandler(Exception.class)
    ResponseEntity<ApiResponse<Void>> handlingRuntimeException(Exception exception) {
        log.error("Unhandled Exception", exception);

        ErrorCode errorCode = ErrorCode.UNCATEGORIZED_EXCEPTION;

        ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(AppException.class)
    ResponseEntity<ApiResponse<Void>> handlingAppException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();

        ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(AccessDeniedException.class)
    ResponseEntity<ApiResponse<Void>> handlingAccessDeniedException(AccessDeniedException exception) {
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

        ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse<Void>> handlingValidation(
            MethodArgumentNotValidException exception
    ) {

        String enumKey = exception
                .getFieldError()
                .getDefaultMessage();

        ErrorCode errorCode = ErrorCode.INVALID_KEY;

        Map<String, Object> attributes = null;

        try {

            errorCode = ErrorCode.valueOf(enumKey);

            var constraintViolation =
                    exception
                            .getBindingResult()
                            .getAllErrors()
                            .getFirst()
                            .unwrap(ConstraintViolation.class);

            attributes = constraintViolation
                    .getConstraintDescriptor()
                    .getAttributes();

        } catch (IllegalArgumentException exception1) {

            log.warn(
                    "Invalid validation error key: {}",
                    enumKey
            );
        }

        String message = Objects.nonNull(attributes)
                ? mapAttribute(errorCode.getMessage(), attributes)
                : errorCode.getMessage();

        ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                .code(errorCode.getCode())
                .message(message)
                .build();

        return ResponseEntity
                .badRequest()
                .body(apiResponse);
    }

    private String mapAttribute(
            String message,
            Map<String, Object> attributes
    ) {

        String minValue =
                String.valueOf(attributes.get(MIN_ATTRIBUTE));

        return message.replace(
                "{" + MIN_ATTRIBUTE + "}",
                minValue
        );
    }
}
