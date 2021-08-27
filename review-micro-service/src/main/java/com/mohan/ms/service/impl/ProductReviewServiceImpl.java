package com.mohan.ms.service.impl;


import com.mohan.ms.domain.ProductReview;
import com.mohan.ms.repository.ProductReviewRepository;
import com.mohan.ms.service.ProductReviewService;
import com.mohan.ms.service.dto.ProductReviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductReviewServiceImpl implements ProductReviewService {

	private final ProductReviewRepository productRepository;

	public ProductReviewServiceImpl(ProductReviewRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductReviewDTO> getAllReviewByProductId(String productId) {
		List<ProductReview> reviewMessage = productRepository.findAllByProductId(productId);

		return null;
	}
}
