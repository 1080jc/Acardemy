package com.proyect.acardemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.acardemy.model.User;
import com.proyect.acardemy.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public boolean existePorCorreo(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public void guardar(User user) {
        userRepository.save(user);
    }

    public User buscarPorCorreoYContraseña(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User obtenerPorCorreo(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }


}