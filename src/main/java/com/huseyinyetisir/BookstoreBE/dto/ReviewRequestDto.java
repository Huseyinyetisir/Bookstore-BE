package com.huseyinyetisir.BookstoreBE.dto;

import java.util.Optional;

import lombok.Data;

@Data
public class ReviewRequestDto {

    private double rating;

    private Long bookId;

    private Optional<String> reviewDescription;

}
