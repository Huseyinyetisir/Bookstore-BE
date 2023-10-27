package com.huseyinyetisir.BookstoreBE.dao;

import com.huseyinyetisir.BookstoreBE.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
