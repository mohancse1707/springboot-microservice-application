package com.mohan.ms.service;

import com.mohan.ms.domain.Product;
import com.mohan.ms.service.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProductByProductId(String productId);

}
