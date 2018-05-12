package com.springcloud.serviceribbon.controller;

import com.springcloud.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件名： HelloControler
 * <p>
 * <p>
 * <p>
 * 北京中油瑞飞信息技术有限公司（http://www.richfit.com）
 * Copyright 2017 Richfit Information Technolagy Co., LTD. All Right Reserved.
 */
@RestController
public class HelloControler {
    @Autowired
    HelloService helloService;
    @Value("${server.port}")
    String port;
    @Value("${spring.application.name}")
    String serviceName;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name)+"  through " + port +"["+serviceName+"]";
    }
}
