package com.mohan.ms.client;

import com.mohan.ms.service.dto.ProductDTO;

public class ProductFeignClientFallback implements ProductFeignClient {

    @Override
    public ProductDTO getProductById(String productId) {
        return null;
    }

}