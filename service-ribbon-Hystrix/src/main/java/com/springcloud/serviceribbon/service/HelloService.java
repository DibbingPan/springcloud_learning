package com.springcloud.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 文件名： HelloService
 * <p>
 * <p>
 * <p>
 * 北京中油瑞飞信息技术有限公司（http://www.richfit.com）
 * Copyright 2017 Richfit Information Technolagy Co., LTD. All Right Reserved.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
