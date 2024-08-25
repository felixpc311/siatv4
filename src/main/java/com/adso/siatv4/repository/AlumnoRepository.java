package com.adso.siatv4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.siatv4.entity.Alumno;
import com.adso.siatv4.projections.AlumnoProjections.AlumnoIdAndNames;
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    public Alumno findByDni(String dni);
    Optional<AlumnoIdAndNames> findAlumnoById(Long id);
}
