package com.adso.siatv4.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siatv4.entity.Alumno;
import com.adso.siatv4.projections.AlumnoProjections.AlumnoIdAndNames;
import com.adso.siatv4.repository.AlumnoRepository;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno findByDni(String dni) {
        return alumnoRepository.findByDni(dni);
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno update(Long id, Alumno alumno) {
        alumno.setId(id);
        return alumnoRepository.save(alumno);
    }

    public void delete(Alumno alumno) {
        alumnoRepository.delete(alumno);
    }

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    public AlumnoIdAndNames findAlumnoById(Long id) {
        return alumnoRepository.findAlumnoById(id).orElse(null);
    }
}
