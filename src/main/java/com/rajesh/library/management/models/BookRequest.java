package com.rajesh.library.management.models;

import com.rajesh.library.management.entities.Book;
import com.rajesh.library.management.entities.BookDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
@AllArgsConstructor
public class BookRequest {
    private String bookName;
    private String author;
    private Date publishedYear;

    public static Book toDTO(BookRequest bookRequest) {
        return Book.builder()
                .bookDetails(BookDetails.builder()
                        .author(bookRequest.getAuthor())
                        .bookName(bookRequest.getBookName())
                        .build())
                .publishedYear(bookRequest.getPublishedYear())
                .build();
    }

}
