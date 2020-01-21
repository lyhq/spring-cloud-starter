package com.you.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by YangRun on 2020/1/21.
 */
@Component
@FeignClient(name = "eureka-producer", /*fallback = HystrixFeignFallback.class,*/ fallbackFactory = CustomFallbackFactory.class)
public interface HystrixFeign {

    @GetMapping(value = "/test")
    String produce(@RequestParam("name") String name);
}
