package com.generic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {


    private  <T extends UsuarioAble> String validarGeneric(T tipo) {
        return tipo.getUsuario();
    }

    @GetMapping(value = "/get-generic")
    public String getFeignService() {
        System.out.println("=======");
        System.out.println(validarGeneric(new CualquierDTO()));
        System.out.println(validarGeneric(new CualquierOtroDTO()));
        System.out.println("=======");

        return "ok";
    }
}

interface UsuarioAble<T> {
    public String getUsuario();
}

class CualquierDTO implements UsuarioAble {
    public String getUsuario() {
        return "CualquierDTO";
    }
}

class CualquierOtroDTO implements UsuarioAble {
    public String getUsuario() {
        return "CualquierOtroDTO";
    }
}