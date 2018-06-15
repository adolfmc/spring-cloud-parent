package com.neo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(FallbackProvider.class);

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        logger.info("request  name is "+name);
        String url = request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort()  + request.getServletPath();
        return "hello master "+name+"，this is first messge , url= "+url;
    }
}