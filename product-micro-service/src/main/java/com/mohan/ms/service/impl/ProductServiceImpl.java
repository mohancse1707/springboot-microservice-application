package com.mohan.ms.service.impl;


import com.mohan.ms.domain.Product;
import com.mohan.ms.repository.ProductRepository;
import com.mohan.ms.service.ProductReviewServiceProxy;
import com.mohan.ms.service.ProductService;
import com.mohan.ms.service.dto.ProductDTO;
import com.mohan.ms.service.dto.ProductReviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ProductReviewServiceProxy productReviewServiceProxy;

	public ProductServiceImpl(ProductRepository productRepository, ProductReviewServiceProxy productReviewServiceProxy) {
		this.productRepository = productRepository;
		this.productReviewServiceProxy = productReviewServiceProxy;
	}

	@Override
	public ProductDTO getProductByProductId(String productId) {
		Product productEntity = productRepository.findOneByProductId(productId);
		// List<ProductReviewDTO> reviewMessage = productReviewServiceProxy.getAllReviewByProductId(productId);
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(productEntity, productDTO);
		if(productEntity != null){
			log.info("**************");
			log.info(productEntity.getProductId());
			log.info(productEntity.getProductTitle());
			log.info("**************");
		}
		return productDTO;
	}

}
