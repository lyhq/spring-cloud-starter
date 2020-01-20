package com.you.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/test")
@RestController
public class TestRibbonController {

    @Qualifier("balancedRestTemplate")
    @Autowired
    private RestTemplate balancedRestTemplate;

    @Qualifier("notBalancedRestTemplate")
    @Autowired
    private RestTemplate notBalancedRestTemplate;

    @GetMapping("/balanced")
    public String testBalanced(@RequestParam String name) {
        name += ",";
        String url = "http://eureka-producer/test?name=" + name;
        return balancedRestTemplate.getForObject(url, String.class);
    }

    @GetMapping("/notBalanced")
    public String testNotBalanced(@RequestParam String name) {
        name += ",";
        String url = "http://127.0.0.1:7001/test?name=" + name;
        return notBalancedRestTemplate.getForObject(url, String.class);
    }

}
