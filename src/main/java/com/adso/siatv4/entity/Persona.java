package com.adso.siatv4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@SuperBuilder
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String dni;
    @Column(nullable = false, length = 50)
    private String apellido1;
    @Column(nullable = true, length = 50)
    private String apellido2;

    @Column(nullable = false, length = 50)
    private String nombre1;
    @Column(nullable = true, length = 50)
    private String nombre2;

    @Column(nullable = true, length = 100)
    private String email;
    @Column(nullable = false, length = 10)
    private String telefono;
}

