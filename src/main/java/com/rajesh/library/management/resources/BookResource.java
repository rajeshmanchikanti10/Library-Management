package com.rajesh.library.management.resources;

import com.rajesh.library.management.Exception.LibraryException;
import com.rajesh.library.management.Response.BookResponse;
import com.rajesh.library.management.entities.Book;
import com.rajesh.library.management.enums.ErrorCode;
import com.rajesh.library.management.models.BookRequest;
import com.rajesh.library.management.services.BookService;
import com.rajesh.library.management.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/book")
@CacheConfig(cacheNames = {"books"})
public class BookResource {
    @Autowired
    private BookService bookService;
    @PostMapping
    public BookResponse<Book> addBook(@RequestBody  BookRequest bookRequest){
        return bookService.addBook(BookRequest.toDTO(bookRequest))
                .map(ResponseUtils::toBookResponse)
                .orElseThrow(()->new LibraryException(ErrorCode.CREATION_ERROR,"Creation Error"));

    }
    @GetMapping("/{bookName}/{authorName}")
    //@Cacheable(key={"$bookName","#author"})
    public BookResponse<Book> getBook(@PathVariable("bookName") String bookName,@PathVariable("authorName") String authorName){
        return bookService.getBook(bookName,authorName)
                .map(ResponseUtils::toBookResponse)
                .orElseThrow(()->new LibraryException(ErrorCode.NOT_FOUND,"Student Not Found"));
    }
}
