package com.huseyinyetisir.BookstoreBE.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huseyinyetisir.BookstoreBE.entity.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);

    List<Checkout> findBooksByUserEmail(String userEmail);

}
