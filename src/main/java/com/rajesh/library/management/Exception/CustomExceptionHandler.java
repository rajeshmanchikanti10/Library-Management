package com.rajesh.library.management.Exception;

import com.rajesh.library.management.Response.BookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({LibraryException.class})
    public ResponseEntity<BookResponse> handleLibraryException(LibraryException ex){
        BookResponse bookResponse = BookResponse.builder().success(false).data(ex.getMessage()).build();
        return ResponseEntity.status(ex.getHttpStatusCode()).body(bookResponse);
    }
}
