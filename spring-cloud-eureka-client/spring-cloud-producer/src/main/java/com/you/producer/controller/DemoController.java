package com.you.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/***
 * DemoController 类
 *
 * @author: YangRun
 * @date: 2020/1/19
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @Value("${config.producer.instance:1}")
    private int instance;

    @GetMapping("")
    public String produce(@RequestParam String name) {
        return "[" + instance + "]" + "你好, " + name + " " + new Date();
    }
}
