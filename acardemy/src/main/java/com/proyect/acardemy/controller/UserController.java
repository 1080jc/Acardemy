package com.proyect.acardemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.proyect.acardemy.model.User;
import com.proyect.acardemy.service.UserService;

import jakarta.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.spring6.expression.Fields;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //Metodo para registrar usuario
    @GetMapping("/register")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("user", new User());
        return "register/registerUser";
    }

    @PostMapping("/register")
    public String registrarPropietario(@Valid @ModelAttribute User user, Model model) {
        if (userService.existePorCorreo(user.getEmail())) {
            model.addAttribute("error");
            return "register/registerUser";
        }
        userService.guardar(user);
        return "redirect:/?index/index=exito";
    }

    //Metodo para iniciar sesion
    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("user", new User());
        return "login/loginUser";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute User user, RedirectAttributes redirectAttributes) {
        User encontrado = userService.buscarPorCorreoYContraseña(user.getEmail(), user.getPassword());
        if (encontrado != null) {
            redirectAttributes.addFlashAttribute("user", encontrado);
            return "redirect:/panelPrincipal";
        } else {
            redirectAttributes.addFlashAttribute("error");
            return "redirect:/login";
        }
    }


    //metodo para panel proncipal
    @GetMapping("/panelPrincipal")
    public String mostrarPanel(@ModelAttribute User user, Model model) {
        if (user == null){
            return "redirect:/login";
        }
        else {
            model.addAttribute("user", user);
            return "/panel/panelPrincipal";
        }

    }

}