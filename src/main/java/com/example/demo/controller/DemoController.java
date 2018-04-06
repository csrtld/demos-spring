package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    Environment env;

    @Value("${nombre}")
    String quien;

    @GetMapping(value = "/saludo")
    public String methodVault() {
        return "salida: " + env.getProperty("saludo") + " " + quien;
    }

}
