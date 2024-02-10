package com.rajesh.library.management.utils;

import com.rajesh.library.management.Response.BookResponse;
import com.rajesh.library.management.models.BookRequest;

public class ResponseUtils {
    public static <T> BookResponse<T> toBookResponse(T data){
        return BookResponse.<T>builder()
                .data(data)
                .success(true)
                .build();
    }
}
