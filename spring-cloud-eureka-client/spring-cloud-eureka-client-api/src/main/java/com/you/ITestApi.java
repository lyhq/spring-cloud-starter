package com.you;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * ITestApi 类
 *
 * @author: YangRun
 * @date: 2020/1/19
 */
public interface ITestApi {

    /**
     * 服务名
     */
    String SERVER_NAME = "eureka-producer";

    @RequestMapping(value = "/testApi", method = RequestMethod.GET)
    String testApi(@RequestParam("name") String name);
}
