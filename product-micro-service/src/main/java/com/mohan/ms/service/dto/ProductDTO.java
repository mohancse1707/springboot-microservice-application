package com.mohan.ms.service.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable{
    private Long id;
    private String productId;
    private String productTitle;
    private Long price;
    private List<ProductReviewDTO> reviewList;
}
