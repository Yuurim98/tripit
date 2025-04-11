package com.tripit.tripit_backend.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "travel-api")
@Getter
@Setter
public class TravelApiProperties {
    private String baseUrl;
    private String serviceKey;
    private String mobileOs;
    private String mobileApp;
    private String type;
}
