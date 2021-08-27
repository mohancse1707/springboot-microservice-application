package com.mohan.ms.service.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReviewDTO implements Serializable {
    private Long id;
    private String productId;
    private Long averageReviewScore;
    private Long numberOfReview;
}
