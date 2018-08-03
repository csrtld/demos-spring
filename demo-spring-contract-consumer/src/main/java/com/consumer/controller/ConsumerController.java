package com.consumer.controller;

import com.consumer.dto.Saludo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    ConsumerController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/get-saludo")
    public String getSaludo() {
        Saludo saludo = restTemplate.getForObject("http://localhost:8080/get-example", Saludo.class);
        return "Saludo -- " + saludo.getMensaje();
    }
}
