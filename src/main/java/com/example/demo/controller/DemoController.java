package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    Environment env;

    @GetMapping(value = "/saludo")
    public String methodVault() {
        String quien = env.getProperty("nombre");
        return "salida: " + env.getProperty("saludo") + " " + quien;
    }

}
