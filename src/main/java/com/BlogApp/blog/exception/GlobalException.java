package com.BlogApp.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

    // Handle specific exception
    @ExceptionHandler(BlogExceptionClass.class)
    public ResponseEntity<?> handleResourceNotFoundException(BlogExceptionClass blogEx, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND.value(), blogEx.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(AlreadyExistException.class)
//    public ResponseEntity<?> alreadyExistException(AlreadyExistException alreadyExistEx, WebRequest request){
//        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.ALREADY_REPORTED.value(), alreadyExistEx.getMessage(),request.getDescription(false));
//        return new ResponseEntity<>(errorDetails,HttpStatus.ALREADY_REPORTED);
//    }
}
