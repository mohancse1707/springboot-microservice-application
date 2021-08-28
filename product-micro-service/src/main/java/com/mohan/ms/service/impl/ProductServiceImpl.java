package com.mohan.ms.service.impl;


import com.mohan.ms.domain.Product;
import com.mohan.ms.repository.ProductRepository;
import com.mohan.ms.service.ProductReviewServiceProxy;
import com.mohan.ms.service.ProductService;
import com.mohan.ms.service.dto.ProductDTO;
import com.mohan.ms.service.dto.ProductReviewDTO;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductReviewServiceProxy productReviewServiceProxy;


	@Override
	public ProductDTO getProductByProductId(String productId) {
		Product productEntity = productRepository.findOneByProductId(productId);
		List<ProductReviewDTO> reviewDTOList = productReviewServiceProxy.getAllReviewByProductId(productId);
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(productEntity, productDTO);
		productDTO.setReviewList(reviewDTOList);
		return productDTO;
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		List<Product> productEntity = productRepository.findAll();

		List<ProductDTO> productDTOList = new ArrayList<>();
		productEntity.stream().forEach(product -> {
			ProductDTO productDTO = new ProductDTO();
			BeanUtils.copyProperties(product, productDTO);
			productDTOList.add(productDTO);
		});
		return productDTOList;
	}
}
