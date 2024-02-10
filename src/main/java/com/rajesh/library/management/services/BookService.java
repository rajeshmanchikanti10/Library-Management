package com.rajesh.library.management.services;

import com.rajesh.library.management.Exception.LibraryException;
import com.rajesh.library.management.entities.Book;
import com.rajesh.library.management.enums.ErrorCode;
import com.rajesh.library.management.repository.LibraryRepository;
import com.rajesh.library.management.utils.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookService {
    @Autowired
    private LibraryRepository libraryRepository;
    private void throwCreationException(String msg){
        throw new LibraryException(ErrorCode.CREATION_ERROR,msg);
    }
    public Optional<Book> addBook(Book book) {
        Optional<Book> bookInDb = libraryRepository.findByBookNameAuthor(book.getBookDetails().getBookName(), book.getBookDetails().getAuthor());
        log.info(bookInDb.isPresent()+" "+bookInDb.toString());
        bookInDb.ifPresent(b->
        {throwCreationException("Book Already Exists");
        });
        log.info(String.format("Inserting book {}", ObjectMapperUtils.getString(book)));
       return Optional.of(libraryRepository.save(book));
    }
    public Optional<Book> getBook(String bookName, String authorName){
        return libraryRepository.findByBookNameAuthor(bookName,authorName);
    }

}
