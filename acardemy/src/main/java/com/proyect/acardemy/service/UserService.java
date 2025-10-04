package com.proyect.acardemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.acardemy.model.User;
import com.proyect.acardemy.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public boolean existePorId(Long id) {
        return userRepository.existsById(id);
    }

    public void guardar(User user) {
        userRepository.save(user);
    }

    public User buscarPorCorreoYContraseña(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User obtenerPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}