package com.you.feign;

import org.springframework.stereotype.Component;

/***
 * HystrixFallback 类
 *
 * @author: YangRun
 * @date: 2020/1/21
 */
@Component("fallback")
public class HystrixFeignFallback implements HystrixFeign {

    @Override
    public String produce(String name) {
        System.out.println("远程调用失败...fallbackClass...");
        return "Hystrix Fallback... fallbackClass... " + name;
    }
}
