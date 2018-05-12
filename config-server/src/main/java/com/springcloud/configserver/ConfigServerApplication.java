package com.springcloud.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerApplication {

	public static void main(String[] args) {
		System.out.println(String.format("%s >>>>  %s","is proxy","true"));
		System.setProperty("http.proxyHost", "proxy.xn.petrochina");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "proxy.xn.petrochina");
		System.setProperty("https.proxyPort", "8080");
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
