package com.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
@EnableAutoConfiguration
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${server.port}")
	String foo;
	@Value("${current}")
	String current;
//	@Value("${zuul.routes.api-b.serviceId}")
//	String zuulserviceId;
	@RequestMapping(value = "/hi")
	public String hi(){
		return foo+"，"+current;
	}
}
