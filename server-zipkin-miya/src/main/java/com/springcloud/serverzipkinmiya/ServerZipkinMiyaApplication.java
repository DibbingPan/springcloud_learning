package com.springcloud.serverzipkinmiya;

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
public class ServerZipkinMiyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinMiyaApplication.class, args);
	}

	private static final Logger LOG = Logger.getLogger(ServerZipkinMiyaApplication.class.getName());


	@RequestMapping("/hi")
	public String hi(){
		LOG.log(Level.INFO, "hi is being called");
		return "hi i'm miya from 8989!";
	}

//	@RequestMapping("/info")
//	public String info(){
//		LOG.log(Level.INFO, "miya is being called calling http://localhost:8988/info");
//		return restTemplate.getForObject("http://localhost:8988/hi",String.class);
//	}

//	@Autowired
//	private RestTemplate restTemplate;
//
//	@Bean
//	public RestTemplate getRestTemplate(){
//		return new RestTemplate();
//	}
	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
