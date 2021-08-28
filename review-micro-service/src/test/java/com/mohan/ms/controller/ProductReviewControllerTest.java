package com.mohan.ms.controller;

import com.mohan.ms.MapperUtils;
import com.mohan.ms.service.dto.ProductReviewDTO;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductReviewControllerTest extends AbstractTest {
    public static final String ADD_PRODUCT_REVIEW_API = "http://localhost:8083/addProductReview";
    public static final String UPDATE_PRODUCT_REVIEW_API = "http://localhost:8083/updateProductReview";
    public static final String DELETE_PRODUCT_REVIEW_API = "http://localhost:8083/deleteProductReview?id=1";
    public static final String ALL_PRODUCT_REVIEW_API = "http://localhost:8083/all";

    @Test
    public void getAllProductReviewTest() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(ALL_PRODUCT_REVIEW_API)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        ProductReviewDTO[] productReviewList = MapperUtils.mapFromJson(content, ProductReviewDTO[].class);
        assertTrue(productReviewList.length > 0);
    }

    @Test
    public void addProductReviewTest() throws Exception {

        ProductReviewDTO productReviewDTO = ProductReviewDTO.builder()
                .id(1L)
                .productId("AB0001")
                .numberOfReview(20L)
                .averageReviewScore(3L)
                .build();

        String inputJson = MapperUtils.mapToJson(productReviewDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(ADD_PRODUCT_REVIEW_API)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void updateProductReviewTest() throws Exception {

        ProductReviewDTO productReviewDTO = ProductReviewDTO.builder()
                .id(1L)
                .productId("AB0001")
                .numberOfReview(30L)
                .averageReviewScore(4L)
                .build();

        String inputJson = MapperUtils.mapToJson(productReviewDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(UPDATE_PRODUCT_REVIEW_API)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void deleteProductReviewTest() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(DELETE_PRODUCT_REVIEW_API)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
