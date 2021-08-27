package com.mohan.ms;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayAndAuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayAndAuthenticationServiceApplication.class, args);
	}

}
