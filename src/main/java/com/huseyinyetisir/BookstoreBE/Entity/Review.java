package com.huseyinyetisir.BookstoreBE.entity;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "review_description")
    private String reviewDescription;
}
