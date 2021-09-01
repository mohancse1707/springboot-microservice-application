package com.mohan.ms.client;

import com.mohan.ms.configuration.ProductFeignClientConfiguration;
import com.mohan.ms.service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-client",
    url = "https://www.adidas.co.uk",
    configuration = ProductFeignClientConfiguration.class,
    fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {

    @GetMapping("/api/products/{productId}")
    ProductDTO getProductById(@PathVariable String productId);
}