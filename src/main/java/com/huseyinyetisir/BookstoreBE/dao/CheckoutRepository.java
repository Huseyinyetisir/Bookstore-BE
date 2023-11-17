package com.huseyinyetisir.BookstoreBE.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huseyinyetisir.BookstoreBE.Entity.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout,Long>{

    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);
    
}
