package com.spc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudConsumerDept80Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConsumerDept80Application.class, args);
	}
}
