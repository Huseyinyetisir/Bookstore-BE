package com.huseyinyetisir.BookstoreBE.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huseyinyetisir.BookstoreBE.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
