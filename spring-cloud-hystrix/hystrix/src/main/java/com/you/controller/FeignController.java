package com.you.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.you.feign.HystrixFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * FeignController 类
 *
 * @author: YangRun
 * @date: 2020/1/21
 */
@RestController
@RequestMapping("/hystrix/feign")
public class FeignController {

    @Autowired
    private HystrixFeign hystrixFeign;

    /**
     * @HystrixCommand(fallbackMethod = "fallback") 指定回调方法
     */
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping()
    public String test(@RequestParam("name") String name) {
        return hystrixFeign.produce(name);
    }

    public String fallback(String name, Throwable throwable) {
        System.out.println("远程调用失败...fallbackMethod..." + throwable);
        return "hystrix fallback " + name;
    }
}
