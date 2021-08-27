package com.mohan.ms.service;

import com.mohan.ms.service.dto.ProductReviewDTO;

import java.util.List;

public interface ProductReviewService {
    List<ProductReviewDTO> getAllReviewByProductId(String productId);
}
