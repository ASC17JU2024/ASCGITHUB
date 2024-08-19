package com.ecz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaUrl;

    @GetMapping("/config")
    public String getConfig() {
        return "Eureka URL: " + eurekaUrl;
    }
}
