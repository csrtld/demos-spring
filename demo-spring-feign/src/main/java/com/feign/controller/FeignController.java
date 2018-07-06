package com.feign.controller;

import com.feign.client.RemoteCallClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    RemoteCallClient loadBalancer;

    @GetMapping(value = "/get-srv-feign")
    public String srvUri() {
        return "Feign Service: " + loadBalancer.getFeignService();
    }
}
