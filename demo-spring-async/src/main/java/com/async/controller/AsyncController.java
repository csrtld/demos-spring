package com.async.controller;

import com.async.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping(value = "/get-uri")
    public String getFeignService() {
        return null;
    }

    @GetMapping(value = "/run-async")
    public String getRunAsync() throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<String> running1 = asyncService.runAsync();
        CompletableFuture<String> running2 = asyncService.runAsync();
        CompletableFuture<String> running3 = asyncService.runAsync();

        CompletableFuture.allOf(running1, running2, running3).join();

        log.info("Tiempo transcurrido: " + (System.currentTimeMillis() - start));

        log.info("--> " + running1.get());
        log.info("--> " + running2.get());
        log.info("--> " + running3.get());

        return "OK";
    }
}
