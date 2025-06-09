package com.example.officialecomarketspa.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String run;

    @Column(unique = false, nullable = false)
    private String username;

    @Column(unique = false, nullable = false)
    private String lastname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = true)
    private String phone;

    @Column(unique = false, nullable = true)
    private String password;

    @Column(unique = false, nullable = true)
    private Rol role;

    @Column(unique = false, nullable = true)
    private String uniquePassword;

    @PrePersist
    public void prePersist() {
        // Genera la clave única
        if (this.uniquePassword == null) {
            this.uniquePassword = UUID.randomUUID().toString(); // O el método corto que prefieras
        }
        // Asigna un rol por defecto si no se ha establecido uno
        if (this.role == null) {
            this.role = Rol.USUARIO;
        }
    }
}
