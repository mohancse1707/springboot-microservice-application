package com.mohan.ms.controller;

import com.mohan.ms.MapperUtils;
import com.mohan.ms.service.dto.ProductDTO;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductControllerTest extends AbstractTest {
    public static final String ALL_PRODUCT_API = "http://localhost:8081/all";
    public static final String PRODUCT_BYPRODUCT_ID_API = "http://localhost:8081/1";

    @Test
    public void getAllProductReviewTest() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(ALL_PRODUCT_API)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        ProductDTO[] productList = MapperUtils.mapFromJson(content, ProductDTO[].class);
        assertTrue(productList.length > 0);
    }

    @Test
    public void getProductByProductIdTest() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(PRODUCT_BYPRODUCT_ID_API)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        ProductDTO product = MapperUtils.mapFromJson(content, ProductDTO.class);
        assertTrue(product != null);
    }
}
