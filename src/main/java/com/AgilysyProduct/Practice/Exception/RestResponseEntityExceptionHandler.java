package com.AgilysyProduct.Practice.Exception;

import com.AgilysyProduct.Practice.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceCustomException productServiceCustomException) {
        return new ResponseEntity<>(new ErrorResponse().builder().ErrorMessage(productServiceCustomException.getMessage())
                .ErrorCode(productServiceCustomException.getErrorCode()).build(), HttpStatus.NOT_FOUND);
    }

}
