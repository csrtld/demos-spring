package com.async.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @GetMapping(value = "/get-uri")
    public String getFeignService() {
        return null;
    }
}
