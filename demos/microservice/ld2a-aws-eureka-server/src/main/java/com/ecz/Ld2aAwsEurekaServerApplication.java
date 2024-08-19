package com.ecz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Ld2aAwsEurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(Ld2aAwsEurekaServerApplication.class, args);
	}
}
