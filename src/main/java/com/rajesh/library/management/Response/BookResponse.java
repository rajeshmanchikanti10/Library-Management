package com.rajesh.library.management.Response;

import com.rajesh.library.management.models.BookRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse<T> {
    boolean success;
    T data;

}
