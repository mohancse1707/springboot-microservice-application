package com.mohan.ms.service.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ProductDTO {
    private Long id;
    private String productId;
    private String productTitle;
    private Long price;
    private List<ProductReviewDTO> reviewList;
}
