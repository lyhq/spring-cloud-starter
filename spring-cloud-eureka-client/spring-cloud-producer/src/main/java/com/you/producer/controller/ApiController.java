package com.you.producer.controller;

import com.you.ITestApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/***
 * ApiController 类
 *
 * @author: YangRun
 * @date: 2020/1/19
 */
@RestController
public class ApiController implements ITestApi {

    @Value("${config.producer.instance:1}")
    private int instance;

    @Override
    public String testApi(@RequestParam("name") String name) {
        return "[" + instance + "]" + "api-> 你好, " + name + " " + new Date();
    }
}
