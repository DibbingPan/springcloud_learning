package com.springcloud.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件名： HiController
 * <p>
 * <p>
 * <p>
 * 北京中油瑞飞信息技术有限公司（http://www.richfit.com）
 * Copyright 2017 Richfit Information Technolagy Co., LTD. All Right Reserved.
 */
@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String serviceName;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name)+"  through " + port+"["+serviceName+"]";
    }
}