package com.mohan.ms.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {
    private String secret;
    private String base64Secret;
    private long tokenValidityInSeconds;
    private long tokenValidityInSecondsForRememberMe;
}
