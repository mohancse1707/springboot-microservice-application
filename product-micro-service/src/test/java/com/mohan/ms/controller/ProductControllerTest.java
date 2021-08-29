package com.mohan.ms.controller;

import com.mohan.ms.MapperUtils;
import com.mohan.ms.domain.Product;
import com.mohan.ms.service.ProductService;
import com.mohan.ms.service.dto.ProductDTO;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductControllerTest extends AbstractTest {
    public static final String ALL_PRODUCT_API = "http://localhost:8081/all";
    public static final String PRODUCT_BYPRODUCT_ID_API = "http://localhost:8081/1";

    @MockBean
    private ProductService productService;

    @Test
    public void getAllProductReviewTest() throws Exception {

        when(productService.getAllProduct()).thenReturn(getProductDTOList());

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(ALL_PRODUCT_API)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        ProductDTO[] productList = MapperUtils.mapFromJson(content, ProductDTO[].class);
        assertTrue(productList.length > 0);
    }

    @Test
    public void getProductByProductIdTest() throws Exception {

        when(productService.getProductByProductId(anyString())).thenReturn(getProductDTO());

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(PRODUCT_BYPRODUCT_ID_API)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        ProductDTO product = MapperUtils.mapFromJson(content, ProductDTO.class);
        assertTrue(product != null);
    }

    private List<ProductDTO> getProductDTOList() {
        List<ProductDTO> list = new ArrayList<>();
        ProductDTO product = new ProductDTO().builder()
                .id(1L)
                .productId("L0001")
                .productTitle("Lenovo Laptop")
                .price(10000L)
                .build();

        ProductDTO product1 = new ProductDTO().builder()
                .id(2L)
                .productId("L0001")
                .productTitle("Lenovo Laptop")
                .price(10000L)
                .build();
        list.add(product);
        list.add(product1);
        return list;
    }

    private ProductDTO getProductDTO() {
        ProductDTO productDTO = new ProductDTO().builder()
                .id(1L)
                .productId("L0001")
                .productTitle("Lenovo Laptop")
                .price(10000L)
                .build();
        return productDTO;
    }
}
