package com.proyect.acardemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/index")
    public String Inicio() {
        return "index/index";
    }

    @GetMapping("/terminos")
    public String TerminosCondiciones() {
        return "index/terminos";
    }

    @GetMapping("/politicas")
    public String PoliticasPrivacidad() {
        return "index/politicas";
    }

    @GetMapping("/contactos")
    public String Contactos() {
        return "index/contactos";
    }

    @GetMapping("/acerca")
    public String Acerca() {
        return "index/acerca";
    }

}
