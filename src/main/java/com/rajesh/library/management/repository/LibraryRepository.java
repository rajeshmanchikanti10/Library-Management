package com.rajesh.library.management.repository;

import com.rajesh.library.management.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Book,Long> {
    @Query("SELECT e FROM Books  e WHERE e.bookDetails.bookName = :bookName AND e.bookDetails.author = :author")
     Optional<Book> findByBookNameAuthor(@Param("bookName") String bookName, @Param("author") String authorName);
}
