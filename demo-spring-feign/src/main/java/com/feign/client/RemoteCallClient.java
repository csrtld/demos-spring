package com.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("spring-client")
public interface RemoteCallClient {
    @GetMapping(value = "/get-feign-uri")
    String getFeignService();
}
