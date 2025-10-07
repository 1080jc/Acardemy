package com.proyect.acardemy.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "correo", nullable = false, unique = true)
    private String email;

    @Column(name = "contraseña", nullable = false)
    private String password;

    @Column(name = "fecha de registro")
    private LocalDate fechaRegistro;


    //Constructores
    public User() {
    }

    public User(Long id, String nombre, String apellido, String email, String password, LocalDate fechaRegistro) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
