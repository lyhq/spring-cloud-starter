package com.you.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/***
 * RibbonController 类
 *
 * @author: YangRun
 * @date: 2020/1/21
 */
@RestController
@RequestMapping("/hystrix/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @HystrixCommand(fallbackMethod = "fallback") 指定回调方法
     */
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping()
    public String test(@RequestParam("name") String name) {
        return restTemplate.getForObject("http://eureka-producer/test?name=" + name, String.class);
    }

    public String fallback(String name, Throwable throwable) {
        System.out.println("远程调用失败...fallbackMethod... " + throwable);
        return "hystrix fallback " + name;
    }
}
