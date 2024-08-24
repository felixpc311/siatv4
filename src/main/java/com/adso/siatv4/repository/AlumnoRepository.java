package com.adso.siatv4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.siatv4.entity.Alumno;
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    public Alumno findByDni(String dni);
}
