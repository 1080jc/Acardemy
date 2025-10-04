package com.proyect.acardemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyect.acardemy.model.User;
import com.proyect.acardemy.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registerUser")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new User());
        return "register/registerUser";
    }

    @PostMapping("/registerUser")
    public String registrarPropietario(@Valid @ModelAttribute User user, Model model) {
        if (userService.existePorCorreo(user.getEmail())) {
            model.addAttribute("error", "el usuario ya esta registrado");
            return "register/registerUser";
        }
        userService.guardar(user);
        return "redirect:/?index=exito";
    }
    
    @GetMapping("/loginUser")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new User());
        return "login/loginUser";
    }

    @PostMapping("/loginUser")
    public String LoginPropietario(@ModelAttribute User user, Model model) {
        User encontrado = userService.buscarPorCorreoYContraseña(user.getEmail(), user.getPassword());

        if (encontrado != null) {
            model.addAttribute("usuario", encontrado);
            return "redirect:/panel/panelPrincipal?correo=" + encontrado.getEmail();
        } else {
            model.addAttribute("error", "correo o contraseña incorrectos");
            return "login/loginUser";
        }
    }

}