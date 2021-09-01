package com.mohan.ms.service.impl;


import com.mohan.ms.client.ProductFeignClient;
import com.mohan.ms.service.ProductReviewServiceProxy;
import com.mohan.ms.service.ProductService;
import com.mohan.ms.service.dto.ProductDTO;
import com.mohan.ms.service.dto.ProductReviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductReviewServiceProxy productReviewServiceProxy;

	@Autowired
	private ProductFeignClient productFeignClient;

	@Override
	public ProductDTO getProductByProductId(String productId) {
		//Product productEntity = productRepository.findOneByProductId(productId);
		ProductDTO productDTO = new ProductDTO();
		System.out.println("***************");
		productDTO = productFeignClient.getProductById(productId);
		System.out.println("***************");
		System.out.println(productDTO.getName());
		System.out.println("***************");
		List<ProductReviewDTO> reviewDTOList = productReviewServiceProxy.getAllReviewByProductId(productId);

		//BeanUtils.copyProperties(productEntity, productDTO);
		productDTO.setReviewList(reviewDTOList);
		return productDTO;
	}

}
