package com.proyect.acardemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String inicio() {
        return "index/index";
    }

    @GetMapping("/index")
    public String Inicio() {
        return "index/index";
    }

}
