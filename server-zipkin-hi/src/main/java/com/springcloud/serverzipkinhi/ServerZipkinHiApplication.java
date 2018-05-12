package com.springcloud.serverzipkinhi;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServerZipkinHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinHiApplication.class, args);
	}

	private static final Logger LOG = Logger.getLogger(ServerZipkinHiApplication.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/info")
	public String info(){
		LOG.log(Level.INFO, "service-hi calling trace service-miya  ");
		return restTemplate.getForObject("http://localhost:8989/hi", String.class);
	}
//	@RequestMapping("/hi")
//	public String hi(){
//		LOG.log(Level.INFO, "calling trace service-hi from 8988!");
//		return "i'm service-hi  from 8988!";
//	}

	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
