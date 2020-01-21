package com.you.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/***
 * CustomFallbackFactory 类
 *
 * @author: YangRun
 * @date: 2020/1/21
 */
@Component
public class CustomFallbackFactory implements FallbackFactory<HystrixFeign> {

    @Qualifier("fallback")
    @Autowired
    private HystrixFeign hystrixFeign;

    @Override
    public HystrixFeign create(Throwable throwable) {
        System.out.println("远程调用异常...createMethod... " + throwable);
        //返回接口HystrixFeign的实现类
        return hystrixFeign;
    }
}
