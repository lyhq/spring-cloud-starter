package com.you.feign;

import com.you.ITestApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by YangRun on 2020/1/19.
 */
//The bean 'eureka-producer.FeignClientSpecification' could not be registered.
//A bean with that name has already been defined and overriding is disabled.
@FeignClient(name = ITestApi.SERVER_NAME, contextId = "api")
    public interface TestApi extends ITestApi {
}
