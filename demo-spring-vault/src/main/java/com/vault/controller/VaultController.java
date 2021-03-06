package com.vault.controller;

import com.vault.configuration.Constantes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class VaultController {

    @Value("${nombre}")
    String quien;

    @GetMapping(value = "/saludar")
    public String methodVault() {
        return Constantes.SALUDO + quien;
    }
}
