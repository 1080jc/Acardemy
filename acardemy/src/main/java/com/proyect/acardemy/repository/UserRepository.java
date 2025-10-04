package com.proyect.acardemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyect.acardemy.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByEmailAndPassword(String email, String password);
    
}
