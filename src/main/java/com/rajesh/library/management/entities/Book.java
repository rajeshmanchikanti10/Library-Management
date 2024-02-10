package com.rajesh.library.management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity(name = "Books")
@Table
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @EmbeddedId
    BookDetails bookDetails;
    @Column
    Date publishedYear;
}
