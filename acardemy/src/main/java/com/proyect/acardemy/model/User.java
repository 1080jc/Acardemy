package com.proyect.acardemy.model;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificacion", nullable = false, unique = true)
    private Long id;

    @Column(name = "nombre", nullable = false)
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @Column(name = "apellido", nullable = false)
    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellido;

    @Column(name = "correo", nullable = false, unique = true)
    @NotBlank(message = "El correo no puede estar vacio")
    private String email;

    @Column(name = "contraseña", nullable = false)
    @NotBlank(message = "La contraseña no puede estar vacio")
    private String password;

    @Column(name = "fecha de registro", nullable = false)
    private LocalDateTime fechaRegistro;

    
}
