package com.producer.controller;

import com.producer.dto.Saludo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @GetMapping(path = "/get-example", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Saludo> getExample() {
        Saludo saludo = Saludo.builder()
                .mensaje("Hola Mundo CDC")
                .build();
        return ResponseEntity.status(200).body(saludo);
    }
}
