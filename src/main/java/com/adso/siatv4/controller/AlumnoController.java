package com.adso.siatv4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.siatv4.entity.Alumno;
import com.adso.siatv4.projections.AlumnoProjections.AlumnoIdAndNames;
import com.adso.siatv4.response.ResponseHandler;
import com.adso.siatv4.service.AlumnoService;
import com.adso.siatv4.utility.Utilities;

@RestController
@RequestMapping("/api/v4/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/getByDni/{dni}")
    public ResponseEntity<Object> getByDni(@PathVariable String dni) {
        
        Alumno alumno = alumnoService.findByDni(dni);
        
        return alumno == null ? ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.NOT_FOUND)
                : ResponseHandler.generateResponseSuccess(
                        Utilities.MESSAGE_RECORD,
                        HttpStatus.OK,
                        alumno);
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_ALL_RECORDS,
                HttpStatus.OK,
                alumnoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        AlumnoIdAndNames alumno = alumnoService.findAlumnoById(id);
        return alumno == null ? ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.NOT_FOUND)
                : ResponseHandler.generateResponseSuccess(
                        Utilities.MESSAGE_RECORD,
                        HttpStatus.OK,
                        alumno);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Alumno alumno) {
        Alumno alumnoSaved = alumnoService.save(alumno);
        return (alumnoSaved != null ? ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_CREATE, HttpStatus.CREATED, alumnoSaved)
                : ResponseHandler.generateResponseError(
                        Utilities.MESSAGE_NOT_CREATE,
                        HttpStatus.BAD_REQUEST));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Alumno alumno) {
        Alumno alumnoUpdated = alumnoService.update(id, alumno);
        return (alumnoUpdated != null ? ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE, HttpStatus.OK, alumnoUpdated)
                : ResponseHandler.generateResponseError(
                        Utilities.MESSAGE_NOT_UPDATE,
                        HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody Alumno alumno) {
        Long alumnoId = alumno.getId();
        alumnoService.delete(alumno);
        return alumnoService.findById(alumnoId) == null ? ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_DELETE,
                HttpStatus.OK,
                null)
                : ResponseHandler.generateResponseError(
                        Utilities.MESSAGE_NOT_DELETE,
                        HttpStatus.BAD_REQUEST);
    }
}
