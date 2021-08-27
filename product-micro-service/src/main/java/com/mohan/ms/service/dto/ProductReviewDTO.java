package com.mohan.ms.service.dto;

import lombok.*;

import java.io.Serializable;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ProductReviewDTO implements Serializable {
    private Long id;
    private String productId;
    private Long averageReviewScore;
    private Long numberOfReview;
}
