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


    // Variables
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


    //Constructores
    public User() {
    }

    public User(Long id, String nombre, String apellido, String email, String password, LocalDateTime fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
    }


    //Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre no puede estar vacio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre no puede estar vacio") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "El apellido no puede estar vacio") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "El apellido no puede estar vacio") String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank(message = "El correo no puede estar vacio") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "El correo no puede estar vacio") String email) {
        this.email = email;
    }

    public @NotBlank(message = "La contraseña no puede estar vacio") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "La contraseña no puede estar vacio") String password) {
        this.password = password;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
