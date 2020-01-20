package com.you.controller;

import com.you.feign.TestApi;
import com.you.feign.TestRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private TestRemote testRemote;

    @Autowired
    private TestApi testApi;

    @GetMapping("")
    public String test(@RequestParam("name") String name) {
        return testRemote.produce(name + "!");
    }

    @GetMapping("/api")
    public String testApi(@RequestParam("name") String name) {
        return testApi.testApi(name + "!");
    }

}
