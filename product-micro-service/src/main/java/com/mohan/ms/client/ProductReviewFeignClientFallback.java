package com.mohan.ms.client;

import com.mohan.ms.service.ProductReviewServiceProxy;
import com.mohan.ms.service.dto.ProductReviewDTO;

import java.util.List;

public class ProductReviewFeignClientFallback implements ProductReviewServiceProxy {


    @Override
    public List<ProductReviewDTO> getAllReviewByProductId(String productId) {
        return null;
    }
}