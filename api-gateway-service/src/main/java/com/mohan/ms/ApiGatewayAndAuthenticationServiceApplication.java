package com.mohan.ms;
import com.mohan.ms.properties.ApplicationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableConfigurationProperties({ApplicationProperties.class})
public class ApiGatewayAndAuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayAndAuthenticationServiceApplication.class, args);
	}

}
