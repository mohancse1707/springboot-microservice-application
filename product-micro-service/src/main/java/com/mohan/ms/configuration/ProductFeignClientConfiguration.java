package com.mohan.ms.configuration;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class ProductFeignClientConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("content-type", "application/json");
            requestTemplate.header("accept", "application/json");
            requestTemplate.header("accept-encoding", "identity");
            requestTemplate.header("cache-control", "no-cache");
            requestTemplate.header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36");
        };
    }
}
