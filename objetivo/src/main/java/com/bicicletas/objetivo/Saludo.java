package com.bicicletas.objetivo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")

public class Saludo{

    @GetMapping()
    public String hola(){
        return "hola";
    }
}