package com.client.controller;

import com.client.dto.Saludo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private EurekaClient discoveryClient;

    @GetMapping(value = "/get-feign-uri")
    public String getFeignService() {
        InstanceInfo instance =  discoveryClient.getNextServerFromEureka("spring-feign",false);
        return instance.getHomePageUrl();
    }

    @GetMapping(value = "/get-dto")
    public Saludo getDtoService() {
        return new Saludo();
    }
}
